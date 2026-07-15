import com.dsaarena.model.Arena;
import com.dsaarena.repository.ArenaRepository;

public class Main {
    public static void main(String[] args) {
        ArenaRepository repo = new ArenaRepository();
        Arena arena = repo.getArenaById(101);
        System.out.println(arena.getArenaName());
    }
}