import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;


@PageEntry(title = "Mobile Главная")
public class MainPage extends Page {

	public static final String XPATH_BY_TEXT = "//*[@text='%s']";
	public static final String XPATH_CONTAINS_TEXT = "//*[contains(@text,'%s')]";

	@ElementTitle("Поиск")
	@AndroidFindBy(xpath = "//*[@content-desc='Вкладка @string/category_search']")
	public WebElement tabButton;

	@ElementTitle("Закрыть")
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Закрыть']")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Закрыть']")
	public WebElement closeButton;

	@ElementTitle("Вкладка Главная")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index=1]/android.widget.FrameLayout[@index=0]")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Главная']")
	public WebElement mainButton;

	@ElementTitle("Аватар")
	@AndroidFindBy(id = "com.allgoritm.youla:id/avatar_iv")
	@FindBy(xpath = "//XCUIElementTypeOther[@name='MainProductListVC.NavigationBar.BadgedUserAvatarButton']")
	public WebElement avatarImage;

	@ElementTitle("Назад")
	@AndroidFindBy(className = "android.widget.ImageButton")
	public WebElement exitButton;

	@ElementTitle("Избранное")
	@AndroidFindBy(id = "com.allgoritm.youla:id/icon_iv")
	public WebElement favoriteIcon;

	@ElementTitle("Блок со сторис")
	@AndroidFindBy(id = "com.allgoritm.youla:id/rv")
	@FindBy(xpath = "//XCUIElementTypeCollectionView[@name='AIStoriesPreviewsView.CollectionNode']")
	public WebElement stories;

	@ElementTitle("Вкладка чаты")
	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Чаты') or contains(@content-desc,'чаты')]")
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Сообщения']")
	public WebElement chats;

	@ElementTitle("Добавить в избранное первый товар")
	@AndroidFindBy(id = "com.allgoritm.youla:id/favorite_iv")
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='BaseProductListVC.ProductCellNodeMain.FavoritesButton'])[1]")
	public WebElement addToFavorites;

	@ElementTitle("Дебаг кнопка")
	@AndroidFindBy(id = "com.allgoritm.youla:id/debug_test_iv")
	public WebElement debugButton;

	@ElementTitle("Вкладка избранное")
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Вкладка Избранное']")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Favorites']")
	public WebElement favourites;

	@ElementTitle("Первый товар")
	@AndroidFindBy(id = "com.allgoritm.youla:id/product_iv")
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='BaseProductListVC.ProductCellNodeMain.Photo'])[1]")
	public WebElement firstAd;

	@ElementTitle("Debug test")
	@AndroidFindBy(id = "com.allgoritm.youla:id/debug_test_iv")
	public WebElement saveLog;

	@ElementTitle("Показать объявления")
	@AndroidFindBy(id = "com.allgoritm.youla:id/apply_btn")
	public WebElement applyButton;

	@ElementTitle("Первая сторис")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.view.View[1]")
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='AIStoryPreviewCellNode.PreviewStory.Cell'])[1]")
	public WebElement firstStory;

	@ElementTitle("Местоположение")
	@AndroidFindBy(id = "com.allgoritm.youla:id/address_tv")
	public WebElement addressInput;

	@ElementTitle("Получить бонусы")
	@AndroidFindBy(id = "com.allgoritm.youla:id/positive_button")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Получить бонусы']")
	public WebElement bonusButton;

	@ElementTitle("Войти")
	@AndroidFindBy(id = "com.allgoritm.youla:id/header_btn")
	public WebElement loginButton;

	@ElementTitle("Закрыть попап")
	@AndroidFindBy(id = "android:id/button2")
	public WebElement closePopupButton;

	@ElementTitle("Изменить местоположение")
	@AndroidFindBy(id = "com.allgoritm.youla:id/change_location_tv")
	public WebElement shading;

	@ElementTitle("Вкладка создать объявление")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Вкладка Создать объявление\"]/android.widget.ImageView")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Create']")
	public WebElement newProduct;

	@ElementTitle("Разместите объявление и начните зарабатывать")
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Разместите объявление и начните зарабатывать']")
	public WebElement advertisingText;

	@ElementTitle("Кнопка Закрыть Купол")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Закрыть']")
	public WebElement closeSecurity;

	@ElementTitle("Кнопка Выбор местоположения")
	@FindBy(xpath = "//XCUIElementTypeCollectionView[@name='ListVC.CollectionView']/XCUIElementTypeCell[2]//XCUIElementTypeOther")
	public WebElement geoButton;

	@ElementTitle("Поле Выбор местоположения")
	@FindBy(xpath = "//XCUIElementTypeCollectionView[@name='ListVC.CollectionView']/XCUIElementTypeCell[2]//XCUIElementTypeStaticText")
	public WebElement geoField;

	@ElementTitle("Кнопка сообщения")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Chats']")
	public WebElement messagesButton;

	@ElementTitle("Крестик на видео-селфи")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='AINavigationBar.DismissButton']")
	public WebElement closeVideoSelfie;

	@ElementTitle("Добавить сторис")
	@FindBy(xpath = "//XCUIElementTypeOther[@name='AIStoryPreviewCellNode.CreateStory.Cell']")
	public WebElement addStory;

	@ElementTitle("Кнопка поиска на главной")
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Tabbar_Search']")
	public WebElement findButtonOnTheMainPage;
}