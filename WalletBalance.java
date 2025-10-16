import org.springframework.stereotype.Service;

@Service
public class WalletBalance {

    private final OrderRepository or;

    // @Autowired
    private final DashboardRepo drepo;

    // @Autowired
    private final UserRepo urepo;

    public CompletableFuture<String> OrderPost(Long Id, OrderDto orderDto) throws Exception {

        UserModel umdl = urepo.findById(Id).orElseThrow(() -> new Exception("User Id Not Found"));
        DashboardModel dm = drepo.findByAssetName(orderDto.getAssetName())
                .orElseThrow(() -> new Exception("AssetName Not Found"));

        Double assetPrice = dm.getPrice();

        WalletModel walletBalance = umdl.getWallet();

        Double TotalOrderValue = orderDto.getAssetQuantity() * assetPrice;
    }

}
