package personalFinance.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.prefs.Preferences;

public final class Settings {

    public static final File FONT_EIRIK_RAUDE = new File("font/EirikRaude.ttf");
    public static final File SAVE_DIR = new File("saves/");
    public static final String SAVE_FILE_EXT = "myrus";

    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static final int COUNT_OVERVIEW_ROWS = 10;

    public static final String[] CURRENCIES_CODES = new String[]{"RUB", "USD", "EUR", "BYN", "UAH"};

    private static final File FILE_SETTING = new File("saves/settings.ini");
    private static File FILE_SAVE = new File("saves/default.myrus");

    private static String LANGUAGE = "ru";

    public static File getFileSave() {
        return FILE_SAVE;
    }

    public static void setFileSave(File fileSave) {
        FILE_SAVE = fileSave;
        save();
    }

    public static String getLANGUAGE() {
        return LANGUAGE;
    }

    public static void setLANGUAGE(String language) {
        LANGUAGE = language;
        setLocale();
        save();
    }

    private static void setLocale() {
        if (LANGUAGE.equals("ru"))
            Locale.setDefault(new Locale("ru"));
        else
            Locale.setDefault(new Locale("en"));
    }

    private static void save() {
        try {
            Wini ini = new Wini(FILE_SETTING);
            if (FILE_SAVE != null)
                ini.put("Settings", "FILE_SAVE", FILE_SAVE.getAbsolutePath().replace("\\", "\\\\"));
            ini.store();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void init() {
        try {
            Ini ini = new Ini(FILE_SETTING);
            Preferences prefs = new IniPreferences(ini);
            String file = prefs.node("Settings").get("FILE_SAVE", null);
            if (file != null)
                FILE_SAVE = new File(file);
            String language = prefs.node("Settings").get("LANGUAGE", null);
            if (language != null)
                LANGUAGE = language;
            setLocale();
        } catch (IOException e) {
            save();
        }
    }
}
