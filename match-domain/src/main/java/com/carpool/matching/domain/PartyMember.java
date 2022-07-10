import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
//import javax.persistence.OneToMany;


@Entity
public class PartyMember {
  @Id @GeneratedValue
  Long id;
  Long memberId;
  Long partyId;
}
