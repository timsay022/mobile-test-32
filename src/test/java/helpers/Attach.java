package helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {

    public static void screenshotAs(String attachName) {
        byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(attachName, "image/png", new String(screenshot, StandardCharsets.ISO_8859_1));
    }

    public static void pageSource() {
        String pageSource = getWebDriver().getPageSource();
        Allure.addAttachment("Page source", "text/plain", pageSource, ".txt");
    }

    public static void attachAsText(String attachName, String message) {
        Allure.addAttachment(attachName, "text/plain", message, ".txt");
    }

    public static void addVideo(String sessionId) {
        String html = "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + Browserstack.videoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
        Allure.addAttachment("Video", "text/html", html, ".html");
    }
}