package danny.socialmedia.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class User implements UserDetails  {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "please enter username")
    private String username;

    @NotNull(message = "please enter password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ElementCollection
    private List<String> roles;

    @OneToMany
    @JsonIgnore
    private List<Friend> friends = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return roles.stream().map(roles -> new SimpleGrantedAuthority("ROLE_" + roles)).collect(Collectors.toList());


    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}