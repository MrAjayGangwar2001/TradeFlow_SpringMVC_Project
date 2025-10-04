package com.Portfolio.app.Wallet;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Portfolio.app.Enum.TransactionType;

import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Repository.UserRepo;
import com.Portfolio.app.WalletTransaction.TransactionModel;
import com.Portfolio.app.WalletTransaction.TransactionRepository;
import com.Portfolio.app.WalletTransaction.TransactionService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class WalletService {

    @Autowired
    private WalletRepository wr;
    @Autowired
    private UserRepo Urepo;

    @Autowired
    private TransactionRepository trepo;

    @Autowired
    private TransactionService transactionService;

    public WalletDto AddMoney(WalletDto walletDto, Long Id) throws Exception {
        // Optional<UserModel> um = Urepo.findById(Id);

        // if (um.isPresent()) {
        // For New User
        // UserModel userm = um.get();

        UserModel um = Urepo.findById(Id).orElseThrow(() -> new Exception("User Id Not Found !"));

        WalletModel wm = um.getWallet();
        if (wm == null) {
            WalletModel newWallet = new WalletModel();
            newWallet.setBalance(walletDto.getBalance());
            wr.save(newWallet);
            // wm.setWalletId(walletDto.getWalletId());
            um.setWallet(newWallet);
            // Urepo.save(um.get());
            Urepo.save(um);
            wm = newWallet;
        } else {
            // For Old User
            wm.setBalance(wm.getBalance() + walletDto.getBalance());
            wr.save(wm);
        }
        // WalletDto response = new WalletDto(wm.getWalletId(), wm.getBalance());
        // return response;
        // } else {
        // throw new Exception("User Id Not Found !");
        // }

        transactionService.RecordTransaction(wm, walletDto.getBalance(), TransactionType.Deposit, "Wallet Recharged");

        return new WalletDto(wm.getWalletId(), wm.getBalance());

    }


    public WalletDto DeductBalance(Long Id, Double amount) throws Exception{
        WalletModel wm = wr.findById(Id).orElseThrow(() -> new Exception("We Can Not find the Wallet Id !"));

        if (wm.getBalance() >= amount) {
            wm.setBalance(wm.getBalance() - amount);
            wr.save(wm);

            // For Transaction Record
            TransactionModel tm = new TransactionModel();
            tm.setAmount(amount);
            tm.setType(TransactionType.Withdraw);
            tm.setDescription("Amount has been deducted for an Order");
            tm.setWallet(wm);
            trepo.save(tm);

            WalletDto wdto = new WalletDto(wm.getWalletId(), wm.getBalance());
            return wdto;
        }else{
            throw new Exception("Insufficient Balance !");
        }



    }

    public WalletDto getWalletBalance(Long Id) throws Exception {
        Optional<UserModel> um = Urepo.findById(Id);
        if (um.isPresent()) {
            WalletModel wmdl = um.get().getWallet();

            if (wmdl != null) {
                WalletDto Wdto = new WalletDto(wmdl.getWalletId(), wmdl.getBalance());
                return Wdto;

            } else {
                throw new Exception("Wallet is Not found to this user");
            }
        } else {
            throw new Exception("Wallet Id cant find in database");
        }
    }
}
