package aaloulou.com.foggy.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    public String name;
    public String birthday;
    public String email;
    public String mobile;
    public String iban;
    public String bic;
}
