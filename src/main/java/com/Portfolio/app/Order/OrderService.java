package com.Portfolio.app.Order;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.Portfolio.app.Enum.TransactionType;
import com.Portfolio.app.Exception.CustomException.AssetNotFoundException;
import com.Portfolio.app.Exception.CustomException.InsufficientBalanceException;
import com.Portfolio.app.Exception.CustomException.UserIdNotFoundException;
import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Repository.DashboardRepo;
import com.Portfolio.app.Repository.UserRepo;
import com.Portfolio.app.Wallet.WalletModel;
import com.Portfolio.app.WalletTransaction.TransactionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    // @Autowired
    private final OrderRepository or;

    // @Autowired
    private final DashboardRepo drepo;

    // @Autowired
    private final UserRepo urepo;

    private final TransactionService transactionService;

    @Async
    @Transactional // agar beech me koi error ho jaye to dono save rollback ho jayein.
    public CompletableFuture<String> OrderPost(Long Id, OrderDto orderDto) throws Exception {

        // UserModel umdl = urepo.findById(Id).orElseThrow(() -> new Exception("User Id
        // Not Found"));
        UserModel umdl = urepo.findById(Id).orElseThrow(() -> new UserIdNotFoundException("User Id Not Found"));
        // DashboardModel dm = drepo.findById(Id).orElseThrow(() -> new
        // Exception("Dashboard Id Not Found"));
        DashboardModel dm = drepo.findByAssetName(orderDto.getAssetName())
                .orElseThrow(() -> new AssetNotFoundException("AssetName Not Found"));

        Double assetPrice = dm.getPrice();

        WalletModel walletBalance = umdl.getWallet();

        Double TotalOrderValue = orderDto.getAssetQuantity() * assetPrice;

        if (walletBalance != null && walletBalance.getBalance() != null) {

            if (TotalOrderValue <= walletBalance.getBalance()) {

                try {

                    OrderModel om = new OrderModel();
                    // om.setOrderId(orderDto.getOrderId()); // Can't set Id , It Auto Generated
                    om.setAssetName(orderDto.getAssetName());
                    om.setOrderType(orderDto.getOrderType());
                    om.setAssetQuantity(orderDto.getAssetQuantity());
                    om.setStatus(orderDto.getStatus());
                    om.setDashboard(dm);
                    om.setWallet(walletBalance);
                    // dm.setAssetname(dm.getAssetname());
                    // dm.setPrice(dm.getPrice());

                    // walletBalance.setBalance(walletBalance.getBalance());
                    walletBalance.setBalance(walletBalance.getBalance() - TotalOrderValue);

                    urepo.save(umdl);
                    or.save(om);

                    // Jab OrderPost hoga tab balance deduct hone ka transaction
                    transactionService.RecordTransaction(walletBalance, TotalOrderValue, TransactionType.Withdraw,
                            "Order placed for " + orderDto.getAssetName());

                    Thread.sleep(5000);

                    // This method is non-optimised and blocking code way and also heavy
                    // return CompletableFuture.completedFuture("Order Executed");

                    // Let's see the optimised way to with non-blocking delay

                    return CompletableFuture.supplyAsync(() -> "Order Executed",
                            CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS));

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return CompletableFuture.completedFuture("Something Happened in Thread");

                }

            } else {
                throw new InsufficientBalanceException("Your wallet Balance is less than Order Value");
            }
        } else {
            throw new NullPointerException("Wallet not found for this user !");
        }

    }

    public List<OrderDto> GetAllOrders() throws Exception {
        // OrderModel om = or.findById(Id).orElseThrow(() -> new Exception("Order Id Not
        // Found"));

        List<OrderModel> om = or.findAll();
        List<OrderDto> odto = om.stream().map((x) -> new OrderDto(x.getOrderId(), x.getAssetName(), x.getOrderType(),
                x.getAssetQuantity(), x.getStatus())).toList();
        return odto;
    }
}
