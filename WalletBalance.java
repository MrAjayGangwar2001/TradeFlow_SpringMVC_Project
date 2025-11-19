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















Adarsh Jha
6:57 PM
package com.example.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User implements UserDetails {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
      @Column(unique = true)
   
    private String email;
      @Column(unique = true)
    private  String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(); 
}
  

}