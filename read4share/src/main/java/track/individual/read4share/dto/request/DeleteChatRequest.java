package track.individual.read4share.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteChatRequest {
    @NotNull
    private UUID senderId;
    @NotNull
    private UUID recipientId;
    @NotNull
    private Long advId;
}
