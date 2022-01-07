package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatResponse {
    private UUID senderId;
    private UUID recipientId;
    private String message;
    private LocalDateTime timestamp;
    private boolean read;
}
