package personalFinance.settings;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

final public class Text {
    private static final Map<String, String> date = new HashMap<>();

    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] = get("JANUARY");
        months[1] = get("FEBRUARY");
        months[2] = get("MARCH");
        months[3] = get("APRIL");
        months[4] = get("MAY");
        months[5] = get("JUNE");
        months[6] = get("JULY");
        months[7] = get("AUGUST");
        months[8] = get("SEPTEMBER");
        months[9] = get("OCTOBER");
        months[10] = get("NOVEMBER");
        months[11] = get("DECEMBER");
        return months;
    }

    public static void init() {
        if(Settings.getLANGUAGE().equals("ru")) {
            date.put("PROGRAM_NAME", "Домашняя бухгалтерия");
            date.put("MENU_FILE", "Файл");
            date.put("MENU_EDIT", "Правка");
            date.put("MENU_VIEW", "Вид");
            date.put("MENU_SETTINGS", "Настройки");
            date.put("MENU_HELP", "Помощь");

            date.put("JANUARY", "Январь");
            date.put("FEBRUARY", "Февраль");
            date.put("MARCH", "Март");
            date.put("APRIL", "Апрель");
            date.put("MAY", "Май");
            date.put("JUNE", "Июнь");
            date.put("JULY", "Июль");
            date.put("AUGUST", "Август");
            date.put("SEPTEMBER", "Сентябрь");
            date.put("OCTOBER", "Октябрь");
            date.put("NOVEMBER", "Ноябрь");
            date.put("DECEMBER", "Декабрь");

            date.put("ERROR", "Ошибка");
            date.put("ERROR_TITLE_EMPTY", "Вы не ввели название!");
            date.put("ERROR_IS_EXISTS", "Такая запись уже существует!");
            date.put("ERROR_DATE_FORMAT", "Некорректный формат даты!");
            date.put("ERROR_CODE_EMPTY", "Вы не указали код!");
            date.put("ERROR_CURRENT_EMPTY", "Вы не выбрали валюту");
            date.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью!");
            date.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счет!");
            date.put("ERROR_RATE_INCORRECT", "Некорректное значение курса!");
            date.put("ERROR_AMOUNT_FORMAT", "Некорректный формат суммы!");
            date.put("ERROR_NO_BASE_CURRENCY", "Необходима базовая валюта! " +
                    "Установите сначала этот параметр в другой валюте, потом он снимется в этой автоматически");
            date.put("ERROR_UPDATE_CURRENCIES", "Ошибка при обновлении курсов валют");

            date.put("CONFIRM_EXIT_TEXT", "Вы действительно хотите выйти? Все несохраненный данные будут потерянны!");
            date.put("CONFIRM_EXIT_TITLE", "Подтверждение выхода");
            date.put("CONFIRM_DELETE_TEXT", "Вы уверенны что хотите удалить данную запись?");
            date.put("CONFIRM_DELETE_TITLE", "Подтверждение удаления");

            date.put("YES", "Да");
            date.put("NO", "Нет");

            date.put("MENU_FILE_NEW", "Новый");
            date.put("MENU_FILE_OPEN", "Открыть");
            date.put("MENU_FILE_SAVE", "Сохранить");
            date.put("MENU_FILE_UPDATE_CURRENCIES", "Обновить курс валют");
            date.put("MENU_FILE_EXIT", "Выход");

            date.put("MENU_EDIT_ADD", "Добавить");
            date.put("MENU_EDIT_EDIT", "Изменить");
            date.put("MENU_EDIT_DELETE", "Удалить");

            date.put("MENU_VIEW_OVERVIEW", "Обзор");
            date.put("MENU_VIEW_ACCOUNTS", "Счета");
            date.put("MENU_VIEW_ARTICLES", "Статьи");
            date.put("MENU_VIEW_TRANSACTIONS", "Транзакции");
            date.put("MENU_VIEW_TRANSFERS", "Переводы");
            date.put("MENU_VIEW_CURRENCIES", "Валюты");

            date.put("MENU_SETTING_LANGUAGE", "Язык");
            date.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Русский");
            date.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "Английский");

            date.put("MENU_VIEW_STATISTICS", "Статистика");

            date.put("MENU_HELP_ABOUT", "Помощь");

            date.put("TOOLBAR_OVERVIEW", "Обзор");
            date.put("TOOLBAR_ACCOUNTS", "Счета");
            date.put("TOOLBAR_ARTICLES", "Статьи");
            date.put("TOOLBAR_TRANSACTIONS", "Транзакции");
            date.put("TOOLBAR_TRANSFERS", "Переводы");
            date.put("TOOLBAR_CURRENCIES", "Валюты");
            date.put("TOOLBAR_STATISTICS", "Статистика");

            date.put("ADD", "Добавить");
            date.put("EDIT", "Изменить");
            date.put("DELETE", "Удалить");

            date.put("TODAY", "Сегодня");

            date.put("LABEL_TITLE", "Название:");
            date.put("LABEL_CURRENCY", "Валюта:");
            date.put("LABEL_START_AMOUNT", "Начальный баланс:");
            date.put("LABEL_DATE", "Дата:");
            date.put("LABEL_ACCOUNT", "Счет:");
            date.put("LABEL_ARTICLE", "Статья:");
            date.put("LABEL_AMOUNT", "Сумма:");
            date.put("LABEL_NOTICE", "Примечание:");
            date.put("LABEL_FROM_ACCOUNT", "От куда:");
            date.put("LABEL_TO_ACCOUNT", "Куда:");
            date.put("LABEL_FROM_AMOUNT", "Снято:");
            date.put("LABEL_TO_AMOUNT", "Зачислено:");
            date.put("LABEL_CODE", "Код:");
            date.put("LABEL_RATE", "Курс:");
            date.put("LABEL_ON", "Включено:");
            date.put("LABEL_BASE", "Базовая:");

            date.put("BALANCE_CURRENCIES", "Баланс по валютам");
            date.put("BALANCE", "Итоговый баланс");

            date.put("FC_HOME", "Домашняя директория");
            date.put("FC_OPEN", "Открыть");
            date.put("FC_SAVE", "Сохранить");
            date.put("FC_CANCEL", "Отмена");
            date.put("FC_LOOK", "Папка:");
            date.put("FC_NAME_FILE", "Имя файла:");
            date.put("FC_TYPE_FILE", "Тип файла:");
            date.put("FC_UP", "Вверх");
            date.put("FC_NEW_DIRECTORY", "Новая папка");
            date.put("FC_LIST", "Список");
            date.put("FC_TABLE", "Таблица");
            date.put("FC_NAME", "Имя");
            date.put("FC_SIZE", "Размер");
            date.put("FC_TYPE", "Тип");
            date.put("FC_DATE", "Дата");
            date.put("FC_ATTR", "Атрибуты");
            date.put("FC_ALL_FILTER", "Все файлы");

            date.put("LAST_TRANSACTIONS", "Последние транзакции");
            date.put("ACCOUNTS", "Счета");
            date.put("ARTICLES", "Статьи");
            date.put("TRANSACTIONS", "Транзакции");
            date.put("TRANSFERS", "Переводы");
            date.put("CURRENCIES", "Валюты");
            date.put("STATISTICS", "Статистика");

            date.put("DATE", "Дата");
            date.put("ACCOUNT", "Счет");
            date.put("ARTICLE", "Статья");
            date.put("AMOUNT", "Сумма");
            date.put("NOTICE", "Примечание");
            date.put("TITLE", "Название");
            date.put("FROM_ACCOUNT", "Откуда");
            date.put("TO_ACCOUNT", "Куда");
            date.put("FROM_AMOUNT", "Снято");
            date.put("TO_AMOUNT", "Зачислено");
            date.put("CODE", "Код");
            date.put("RATE", "Курс");
            date.put("ON", "Включено");
            date.put("BASE", "Базовая");

            date.put("CHART_INCOME", "Доходы по статьям");
            date.put("CHART_EXP", "Расходы по статьям");
            date.put("CHART_NO_DATA", "Нет данных за выбранный период!");

            date.put("DIALOG_ABOUT_TITLE", "О программе");
            date.put("ABOUT", "<body style ='font-size:120%; text-align: center; width: 350px;'>" +
                    "<h1>Домашняя бухгалтерия</h1><p><img src='file:images/main.png'/></p>" +
                    "<p>Данная программа была создана в Видеокурсе" +
                    "<br/>\"Создание крупного проекта на JAVA с нуля\"" +
                    "<p>С Уважением, Виктор Баран!</p>" +
                    "<p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");
        } else {
            date.put("PROGRAM_NAME", "Personal Finance");
            date.put("MENU_FILE", "File");
            date.put("MENU_EDIT", "Edit");
            date.put("MENU_VIEW", "View");
            date.put("MENU_SETTINGS", "Settings");
            date.put("MENU_HELP", "Help");

            date.put("JANUARY", "January");
            date.put("FEBRUARY", "February");
            date.put("MARCH", "March");
            date.put("APRIL", "April");
            date.put("MAY", "May");
            date.put("JUNE", "June");
            date.put("JULY", "July");
            date.put("AUGUST", "August");
            date.put("SEPTEMBER", "September");
            date.put("OCTOBER", "October");
            date.put("NOVEMBER", "November");
            date.put("DECEMBER", "December");

            date.put("ERROR", "Error");
            date.put("ERROR_TITLE_EMPTY", "You have not entered a name!");
            date.put("ERROR_IS_EXISTS", "This entry already exists!");
            date.put("ERROR_DATE_FORMAT", "Invalid date format!");
            date.put("ERROR_CODE_EMPTY", "You did not specify the code!");
            date.put("ERROR_CURRENT_EMPTY", "You did not specify the currency!");
            date.put("ERROR_ARTICLE_EMPTY", "You did non specify the article!");
            date.put("ERROR_ACCOUNT_EMPTY", "You did not specify an account!");
            date.put("ERROR_RATE_INCORRECT", "Invalid rate value!");
            date.put("ERROR_AMOUNT_FORMAT", "Invalid amount format!");
            date.put("ERROR_NO_BASE_CURRENCY", "Base currency required! " +
                    "First set this parameter in another currency, then it will be removed in this automatically.");
            date.put("ERROR_UPDATE_CURRENCIES", "Error updating currencies!");

            date.put("CONFIRM_EXIT_TEXT", "Do you really want to exit? All unsaved data will be lost!");
            date.put("CONFIRM_EXIT_TITLE", "Exit confirmation");
            date.put("CONFIRM_DELETE_TEXT", "Are you sure you want to delete this entry?");
            date.put("CONFIRM_DELETE_TITLE", "Confirm");

            date.put("YES", "Yes");
            date.put("NO", "No");

            date.put("MENU_FILE_NEW", "New");
            date.put("MENU_FILE_OPEN", "Open");
            date.put("MENU_FILE_SAVE", "Save");
            date.put("MENU_FILE_UPDATE_CURRENCIES", "Update currencies");
            date.put("MENU_FILE_EXIT", "Exit");

            date.put("MENU_EDIT_ADD", "Add");
            date.put("MENU_EDIT_EDIT", "Edit");
            date.put("MENU_EDIT_DELETE", "Delete");

            date.put("MENU_VIEW_OVERVIEW", "Overview");
            date.put("MENU_VIEW_ACCOUNTS", "Accounts");
            date.put("MENU_VIEW_ARTICLES", "Articles");
            date.put("MENU_VIEW_TRANSACTIONS", "Transactions");
            date.put("MENU_VIEW_TRANSFERS", "Transfers");
            date.put("MENU_VIEW_CURRENCIES", "Currencies");

            date.put("MENU_SETTING_LANGUAGE", "Language");
            date.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Russian");
            date.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "English");

            date.put("MENU_VIEW_STATISTICS", "Statistics");

            date.put("MENU_HELP_ABOUT", "Help");

            date.put("TOOLBAR_OVERVIEW", "Overview");
            date.put("TOOLBAR_ACCOUNTS", "Accounts");
            date.put("TOOLBAR_ARTICLES", "Articles");
            date.put("TOOLBAR_TRANSACTIONS", "Transactions");
            date.put("TOOLBAR_TRANSFERS", "Transfers");
            date.put("TOOLBAR_CURRENCIES", "Currencies");
            date.put("TOOLBAR_STATISTICS", "Statistics");

            date.put("ADD", "Add");
            date.put("EDIT", "Edit");
            date.put("DELETE", "Delete");

            date.put("TODAY", "Today");

            date.put("LABEL_TITLE", "Title:");
            date.put("LABEL_CURRENCY", "Currency:");
            date.put("LABEL_START_AMOUNT", "Start amount:");
            date.put("LABEL_DATE", "Date:");
            date.put("LABEL_ACCOUNT", "Account:");
            date.put("LABEL_ARTICLE", "Article:");
            date.put("LABEL_AMOUNT", "Amount:");
            date.put("LABEL_NOTICE", "Notice:");
            date.put("LABEL_FROM_ACCOUNT", "From:");
            date.put("LABEL_TO_ACCOUNT", "To:");
            date.put("LABEL_FROM_AMOUNT", "Withdrawn:");
            date.put("LABEL_TO_AMOUNT", "Credited:");
            date.put("LABEL_CODE", "Code:");
            date.put("LABEL_RATE", "Rate:");
            date.put("LABEL_ON", "Enable:");
            date.put("LABEL_BASE", "Basic:");

            date.put("BALANCE_CURRENCIES", "Balance by currencies");
            date.put("BALANCE", "Total balance");

            date.put("FC_HOME", "Home");
            date.put("FC_OPEN", "Open");
            date.put("FC_SAVE", "Save");
            date.put("FC_CANCEL", "Cancel");
            date.put("FC_LOOK", "Folder:");
            date.put("FC_NAME_FILE", "File name:");
            date.put("FC_TYPE_FILE", "Тип File type::");
            date.put("FC_UP", "Up");
            date.put("FC_NEW_DIRECTORY", "New folder");
            date.put("FC_LIST", "List");
            date.put("FC_TABLE", "Table");
            date.put("FC_NAME", "Name");
            date.put("FC_SIZE", "Size");
            date.put("FC_TYPE", "Type");
            date.put("FC_DATE", "Date");
            date.put("FC_ATTR", "Attributes");
            date.put("FC_ALL_FILTER", "All files");

            date.put("LAST_TRANSACTIONS", "Last transactions");
            date.put("ACCOUNTS", "Accounts");
            date.put("ARTICLES", "Articles");
            date.put("TRANSACTIONS", "Transactions");
            date.put("TRANSFERS", "Transfers");
            date.put("CURRENCIES", "Currencies");
            date.put("STATISTICS", "Statistics");

            date.put("DATE", "Date");
            date.put("ACCOUNT", "Account");
            date.put("ARTICLE", "Article");
            date.put("AMOUNT", "Amount");
            date.put("NOTICE", "Notice");
            date.put("TITLE", "Title");
            date.put("FROM_ACCOUNT", "From");
            date.put("TO_ACCOUNT", "To");
            date.put("FROM_AMOUNT", "Withdraw");
            date.put("TO_AMOUNT", "Credited");
            date.put("CODE", "Cod");
            date.put("RATE", "Rate");
            date.put("ON", "Enable");
            date.put("BASE", "Basic");

            date.put("CHART_INCOME", "Incomes by articles");
            date.put("CHART_EXP", "Expenses by articles");
            date.put("CHART_NO_DATA", "No data for the selected period!");

            date.put("DIALOG_ABOUT_TITLE", "About");
            date.put("ABOUT", "<body style ='font-size:120%; text-align: center; width: 350px;'>" +
                    "<h1>Personal finance</h1><p><img src='file:images/main.png'/></p>" +
                    "<p>This program was made in the Video Course" +
                    "<br/>\"Creating a large Java project from scratch\"" +
                    "<p>With respect, Victor Baran!</p>" +
                    "<p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");
        }
    }

    public static String get(String key) {
        if (date.containsKey(key))
            return date.get(key);
        System.out.println("Такого ключа в Text не существует");
        return "";
    }
}
