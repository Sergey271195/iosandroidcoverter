
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Mobile Главная")
public class MainPage extends Page {

    @ElementTitle("Аватар")
    @AndroidFindBy(id = "com.allgoritm.youla:id/avatar_iv")
    public WebElement avatarImage;

    @ElementTitle("Дебаг кнопка")
    @AndroidFindBy(id = "com.allgoritm.youla:id/debug_test_iv")
    public WebElement debugButton;

    @ElementTitle("Войти")
//    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'ВОЙТИ')]")
    @AndroidFindBy(id = "com.allgoritm.youla:id/header_btn")
    public WebElement loginButton;

    @ElementTitle("Назад")
    @AndroidFindBy(className = "android.widget.ImageButton")
    public WebElement exitButton;

    @ElementTitle("Местоположение")
    @AndroidFindBy(id = "com.allgoritm.youla:id/address_tv")
    public WebElement addressInput;

    @ElementTitle("Изменить местоположение")
    @AndroidFindBy(id = "com.allgoritm.youla:id/change_location_tv")
    public WebElement shading;

    @ElementTitle("Показать объявления")
    @AndroidFindBy(id = "com.allgoritm.youla:id/apply_btn")
    public WebElement applyButton;

    @ElementTitle("Поиск")
    @AndroidFindBy(xpath = "//*[@content-desc='Вкладка @string/category_search']")
    public WebElement tabButton;

    @ElementTitle("Вкладка Главная")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index=1]/android.widget.FrameLayout[@index=0]")
    public WebElement mainButton;

    @ElementTitle("Получить бонусы")
    @AndroidFindBy(id = "com.allgoritm.youla:id/positive_button")
    public WebElement bonusButton;

    @ElementTitle("Вкладка избранное")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Вкладка Избранное']")
    public WebElement favourites;

    @ElementTitle("Избранное")
    @AndroidFindBy(id = "com.allgoritm.youla:id/icon_iv")
    public WebElement favoriteIcon;

    @ElementTitle("Вкладка чаты")
    //@AndroidFindBy(xpath = "//android.widget.TextView[@text='Сообщения']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Чаты') or contains(@content-desc,'чаты')]")
    @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Chats']")
    //@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Чаты') or contains(@content-desc,'чаты')]")
    //@iOSXCUITFindBy
    public WebElement chats;

    @ElementTitle("Блок со сторис")
    @AndroidFindBy(id = "com.allgoritm.youla:id/rv")
    public WebElement stories;

    @ElementTitle("Первая сторис")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.view.View[1]")
    public WebElement firstStory;

    @ElementTitle("Добавить в избранное первый товар")
    @AndroidFindBy(id = "com.allgoritm.youla:id/favorite_iv")
    public WebElement addToFavorites;

    @ElementTitle("Первый товар")
    @AndroidFindBy(id = "com.allgoritm.youla:id/product_iv")
    public WebElement firstAd;

    @ElementTitle("Закрыть")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Закрыть']")
    public WebElement closeButton;

    @ElementTitle("Закрыть попап")
    @AndroidFindBy(id = "android:id/button2")
    public WebElement closePopupButton;

    @ElementTitle("Debug test")
    @AndroidFindBy(id = "com.allgoritm.youla:id/debug_test_iv")
    public WebElement saveLog;

    @ElementTitle("Вкладка создать объявление")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Вкладка Создать объявление\"]/android.widget.ImageView")
    public WebElement newProduct;
}
