package Collection.Parametres;

/**
 * Класс возможных типов оружия героя
 */
public enum WeaponType {
    AXE,
    SHOTGUN,
    MACHINE_GUN,
    BAT;

    public static String list() {
        StringBuilder resultStr = new StringBuilder();
        for (var names : values()) {
            resultStr.append(names.name()).append("\n");
        }
        return resultStr.toString();
    }
}
