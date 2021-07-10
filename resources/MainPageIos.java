
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "IOS Главная страница")
public class MainPage extends Page {
    public static final String XPATH_BY_TEXT = "//*[@text='%s']";
    public static final String XPATH_CONTAINS_TEXT = "//*[contains(@text, '%s')]";

    @ElementTitle("Разместите объявление и начните зарабатывать")
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Разместите объявление и начните зарабатывать']")
    public WebElement advertisingText;

    @ElementTitle("Аватар")
    @FindBy(xpath = "//XCUIElementTypeOther[@name='MainProductListVC.NavigationBar.BadgedUserAvatarButton']")
    public WebElement avatarButton;

    @ElementTitle("Вкладка Главная")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Главная']")
    public WebElement mainPage;

    @ElementTitle("Закрыть")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Закрыть']")
    public WebElement closePopupOnMainPage;

    @ElementTitle("Получить бонусы")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Получить бонусы']")
    public WebElement getBonusButton;

//    @ElementTitle("Кнопка Добавить объявление")
//
//    @FindBy(xpath = "//XCUIElementTypeButton[@name='tabbarPlusBig']")
//    public WebElement addAdButton;

    @ElementTitle("Вкладка создать объявление")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Create']")
    public WebElement addAdButton2;

    @ElementTitle("Вкладка избранное")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Favorites']")
    public WebElement addToFavorite;

    @ElementTitle("Кнопка сообщения")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Chats']")
    public WebElement messagesButton;

    @ElementTitle("Кнопка поиска на главной")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Search']")
    public WebElement findButtonOnTheMainPage;

    @ElementTitle("Кнопка Выбор местоположения")
    @FindBy(xpath = "//XCUIElementTypeCollectionView[@name='ListVC.CollectionView']/XCUIElementTypeCell[2]//XCUIElementTypeOther")
    public WebElement geoButton;

    @ElementTitle("Поле Выбор местоположения")
    @FindBy(xpath = "//XCUIElementTypeCollectionView[@name='ListVC.CollectionView']/XCUIElementTypeCell[2]//XCUIElementTypeStaticText")
    public WebElement geoField;

    @ElementTitle("Кнопка Закрыть Купол")
//    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    //for the latest versions of app (4.28+)
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Закрыть']")
    public WebElement closeSecurity;

    @ElementTitle("Вкладка чаты")
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Сообщения']")
    public WebElement chats;
  
    @ElementTitle("Блок со сторис")
    @FindBy(xpath = "//XCUIElementTypeCollectionView[@name='AIStoriesPreviewsView.CollectionNode']")
    public WebElement storiesBlock;

    @ElementTitle("Добавить сторис")
    @FindBy(xpath = "//XCUIElementTypeOther[@name='AIStoryPreviewCellNode.CreateStory.Cell']")
    public WebElement addStory;

    @ElementTitle("Первая сторис")
    @FindBy(xpath = "(//XCUIElementTypeOther[@name='AIStoryPreviewCellNode.PreviewStory.Cell'])[1]")
    public WebElement firstStory;

    @ElementTitle("Крестик на видео-селфи")
    @FindBy(xpath = "//XCUIElementTypeButton[@name='AINavigationBar.DismissButton']")
    public WebElement closeVideoSelfie;
  
    @ElementTitle("Добавить в избранное первый товар")
    @FindBy(xpath = "(//XCUIElementTypeButton[@name='BaseProductListVC.ProductCellNodeMain.FavoritesButton'])[1]")
    public WebElement addFirstToFav;

    @ElementTitle("Первый товар")
    @FindBy(xpath = "(//XCUIElementTypeOther[@name='BaseProductListVC.ProductCellNodeMain.Photo'])[1]")
    public WebElement firstAd;
}