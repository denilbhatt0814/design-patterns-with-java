import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Player {
    static PlayerFlyWeightFactory factory = new PlayerFlyWeightFactory();
    static String[] types = new String[] { "Terrorist", "Counter-Terrorist" };
    static String[] weaponsList = new String[] { "AWP", "SG", "FAMAS", "AUG", "DEAGLE", "NEGEV" };
    static int count;

    PlayerFlyWeight pfw;
    String weapon = "knife";
    int id;
    int x;
    int y;

    {
        id = count++;
    }

    public Player(String type) {
        pfw = factory.createPlayerFlyWeight(type);
        System.out.println("New Player: " + this.basicInfo());
    }

    public void spawn(String weapon, int x, int y) {
        this.weapon = weapon;
        this.x = x;
        this.y = y;
        System.out.println("SPAWN: Player [weapon=" + weapon + ", id=" + id + ", x=" + x + ", y=" + y + "]\n");
    }

    public String basicInfo() {
        return "Player [pfw=" + pfw + "]\n";
    }

    @Override
    public String toString() {
        return "Player [pfw=" + pfw + ", weapon=" + weapon + ", id=" + id + ", x=" +
                x + ", y=" + y + "]";
    }
}

class PlayerFlyWeight {
    String type;
    String colorCode;
    String task;

    public PlayerFlyWeight(String type, String colorCode, String task) {
        this.type = type;
        this.colorCode = colorCode;
        this.task = task;
        System.out.println("New PlayerFlyWeight: " + this.toString() + "\n");
    }

    public String toString() {
        return "PlayerFlyWeight [type=" + type + ", colorCode=" + colorCode + ", task=" + task + "]\n";
    }

}

class PlayerFlyWeightFactory {
    Map<String, PlayerFlyWeight> pfwStore = new HashMap<String, PlayerFlyWeight>();

    public PlayerFlyWeight createPlayerFlyWeight(String type) {
        PlayerFlyWeight pfw = null;
        if (pfwStore.containsKey(type)) {
            pfw = pfwStore.get(type);
        } else {
            if (type.equalsIgnoreCase("Counter-Terrorist")) {
                pfw = new PlayerFlyWeight("Counter-Terrorist", "Blue", "DEFENCE");
            } else if (type.equalsIgnoreCase("Terrorist")) {
                pfw = new PlayerFlyWeight("Terrorist", "Copper", "ATTACK");
            } else {
                System.out.println("Player-type not available!!");
            }
            pfwStore.put(type, pfw);
        }
        return pfw;
    }
}

class Game {
    static int playerCount = 10;
    static ArrayList<Player> playersInSession = new ArrayList<Player>();
    static int X_MAX_SESSION = 1000;
    static int Y_MAX_SESSION = 100;

    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player(Player.types[random.nextInt(Player.types.length)]);
            playersInSession.add(player);
            player.spawn(Player.weaponsList[random.nextInt(Player.weaponsList.length)], random.nextInt(X_MAX_SESSION),
                    random.nextInt(Y_MAX_SESSION));
        }

        System.out.println("Popular weapon: " + findPopluarWeaponInSession(playersInSession));
        System.out.println("Right Side in control of: " + findPlayerTypeOnRightSide(playersInSession));
        System.out.println("Approx Memcount: " + calculateApproxMemUsage(playersInSession));
    }

    public static String findPopluarWeaponInSession(ArrayList<Player> playersInSession) {
        String popularWeapon = "";
        Map<String, Integer> weaponToInstances = new HashMap<String, Integer>();

        for (Player player : playersInSession) {
            if (weaponToInstances.containsKey(player.weapon)) {
                weaponToInstances.put(player.weapon, weaponToInstances.get(player.weapon) + 1);
            } else {
                weaponToInstances.put(player.weapon, 1);
            }
        }

        int maxInstances = 0;
        for (Map.Entry<String, Integer> entry : weaponToInstances.entrySet()) {
            if (entry.getValue() > maxInstances) {
                popularWeapon = entry.getKey();
                maxInstances = entry.getValue();
            }
        }

        return popularWeapon;
    }

    public static String findPlayerTypeOnRightSide(ArrayList<Player> playersInSession) {
        String areaInControlOf = "";
        Map<String, Integer> playerTypeToInstancesOnRight = new HashMap<String, Integer>();

        for (Player player : playersInSession) {
            if (player.x > X_MAX_SESSION / 2) {
                if (playerTypeToInstancesOnRight.containsKey(player.pfw.type)) {
                    playerTypeToInstancesOnRight.put(player.pfw.type,
                            playerTypeToInstancesOnRight.get(player.pfw.type) + 1);
                } else {
                    playerTypeToInstancesOnRight.put(player.pfw.type, 1);
                }
            }
        }

        int maxInstances = 0;
        for (Map.Entry<String, Integer> entry : playerTypeToInstancesOnRight.entrySet()) {
            if (entry.getValue() > maxInstances) {
                areaInControlOf = entry.getKey();
                maxInstances = entry.getValue();
            }
        }

        return areaInControlOf;
    }

    public static int calculateApproxMemUsage(ArrayList<Player> playersInSession) {
        int memCount = 30 * 2;

        memCount += playersInSession.size() * (4 + 4 + 4 + 10 + 2 + 2);

        return memCount;
    }
}