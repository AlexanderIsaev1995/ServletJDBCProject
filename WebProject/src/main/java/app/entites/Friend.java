package app.entites;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Friend {
    private String friendName;
    private String password;
}

