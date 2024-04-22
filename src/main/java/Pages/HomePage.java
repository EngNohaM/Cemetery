package Pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HomePage {


    public WebDriverWait wait;
    JavascriptExecutor js;
    private final Actions actions;
    @FindBy(xpath = "//*[@data-kt-menu-placement=\"bottom-end\"]")
    private WebElement createMnu;
    @FindBy(xpath = "//*[@class=\"d-flex align-items-center py-1\"]")
    private WebElement createLeftMnu;
    @FindBy(xpath = "//*[@href=\"/app/correspondences/internal/new\"]")
    private WebElement createInternal;
    @FindBy(xpath = "//*[@data-popper-placement=\"bottom-start\"]//a[@href=\"/app/correspondences/internal/new\"]")
    private WebElement createLeftInternal;
    @FindBy(id = "title")
    private WebElement titleTxt;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitBtn;
    @FindBy(id = "footer")
    private WebElement footerTxt;

    @FindBy(id = "attachmentsCount")
    private WebElement attachmentsCountTxt;

    @FindBy(id = "signerName")
    private WebElement signerNameTxt;
    @FindBy(id = "forwardToStatement")
    private WebElement forwardTxt;
    @FindBy(name = "TypeCombobox")
    private WebElement corTypeDdl;
    @FindBy(id = "executingAgency")
    private WebElement executingAgencyDdl;
    // @FindBy(xpath = "//*[contains(text(),' إدارة الحسابات ')]")
    //@FindBy(xpath = "//*[contains(text(),' إدارة الموارد البشرية ')]")
    //@FindBy(xpath = "//*[@role=\"treeitem\"]//*[@data-treeindex=\"1\"]")use at 83
    @FindBy(xpath = "//*[contains(text(),' إدارة الحسابات ')]") //use at kareem's server
    private WebElement executingAgencyItemDdl;

    @FindBy(xpath = "//*[contains(text(),' الاتصالات الإدارية ')]")
    private WebElement corMnu;
    // @FindBy(xpath = "//*[@href=\"/app/correspondences/draft\"]")

    @FindBy(xpath = "//*[@href=\"/app/correspondences/draft\"]")
    private WebElement draftMnu;

    @FindBy(xpath = "//*[@href=\"/app/correspondences/inbox\"]")
    private WebElement inboxMnu;

    @FindBy(xpath = "//*[@href=\"/app/correspondences/my-inbox\"]")
    private WebElement myInboxMnu;


    @FindBy(id = "code")
    private WebElement idTxt;

    @FindBy(xpath = "//*[@aria-colindex=\"5\"]")
    private List<WebElement> corTypeLst;

    @FindBy(xpath = "//tr[@aria-rowindex=\"2\"]//input[@type=\"checkbox\"]")
    private WebElement itemChck;

    @FindBy(xpath = "//*[@style=\"display: inline-block;\"]")
    private WebElement serverError;

    @FindBy(xpath = "//tr[@aria-rowindex=\"2\"]//td[@data-kendo-grid-column-index=\"3\"]")
    private WebElement checkedCorNo;

    @FindBy(xpath = "//*[@aria-colcount=\"4\"]//*[@class=\"k-grid-container ng-star-inserted\"]")
    private List<WebElement> gridLst;

    @FindBy(xpath = "//*[@class=\"btn btn-sm btn-light-danger\"]")
    private WebElement closeTransferBtn;

    @FindBy(xpath = "//*[@position=\"top\"]//*[contains(text(), ' تحويل ')]")
    private WebElement transferBtn;

    @FindBy(xpath = "//*[text()=' تتبع الإحالات ']")
    private WebElement traceBtn;

    @FindBy(xpath = "//*[text()=' إضافة سطر جديد ']")
    private WebElement addBtn;

    @FindBy(xpath = "//*[@class=\"!k-rounded-left-0 k-picker-md k-rounded-md k-picker-solid k-dropdowntree k-picker ng-pristine ng-valid ng-touched\"]")
    private WebElement dprtmentDDl;

    @FindBy(xpath = "//*[contains(text(),'البرمجة')]")//kareem's server
    //@FindBy(xpath = "//*[contains(text(),' إدارة الحسابات ')]")
    //@FindBy(xpath = "//*[contains(text(),' إدارة الموارد البشرية ')]")
    private WebElement dprtmentItemDdl;

    @FindBy(xpath = "//*[@aria-rowindex=\"2\"]//*[@aria-colindex=\"5\"]//*[@name = \"DeliveryType\"]")
    private WebElement deliveryTypeDdl;

    @FindBy(xpath = "//*[contains(text(),'إليكتروني')]")
    private WebElement deliveryTypeItemDdl;

    // @FindBy(xpath="//*[@data-kendo-grid-column-index=\"2\" and @tabindex=\"0\"]")
    @FindBy(xpath = "//td[contains(text(),'نهى محمد')]")
    private WebElement employeeDDl;

    @FindBy(xpath = "//td[@data-kendo-grid-column-index=\"3\"  and @tabindex=\"0\"]")
    private WebElement chkCopy;

    @FindBy(xpath = "//*[@class=\"btn btn-sm btn-light-success me-1\"]")
    private WebElement SubmitTransferBtn;
    @FindBy(xpath = "//*[@name=\"filterText\"]")
    private WebElement searchTxt;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@data-kendo-grid-column-index=\"3\"]")
    private WebElement corNo;

    @FindBy(xpath = "//button[contains(text(),\" تحويل \")]")
    private WebElement InternalTransfer;

    @FindBy(xpath = "//td[@data-kendo-grid-column-index=\"1\" and @tabindex=\"-1\"]")
    private List<WebElement> datelst;

    //@FindBy(xpath = "//td[@data-kendo-grid-column-index=\"1\" and @tabindex=\"-1\"]")
    @FindBy(xpath = "//td[@data-kendo-grid-column-index=\"1\"]")//kareem's server
    private WebElement typeColumn;

    @FindBy(xpath = "//td[@data-kendo-grid-column-index=\"2\" and @tabindex=\"-1\"]")
    private List<WebElement> transferlst;

    @FindBy(xpath = "//*[text()='المشفوعات']")
    private WebElement hardAttachmentTab;

    @FindBy(xpath = "//*[@class=\"btn btn-secondary btn-sm font-weight-bold me-2\"]")
    private WebElement addLineHardAttachBtn;

    @FindBy(xpath = "//*[@class=\"k-searchbar\"]//*[@class=\"k-input-inner\"]")
    private WebElement attachementDll;

    @FindBy(xpath = "//*[@class='k-touch-action-auto ng-star-inserted' and @data-kendo-grid-column-index=\"2\"]")
    private WebElement qtyTxt;

    @FindBy(xpath = "//*[@class='k-touch-action-auto ng-star-inserted' and @data-kendo-grid-column-index=\"3\"]")
    private WebElement commentTxt;

    @FindBy(xpath = "//*[@data-kendo-grid-item-index=\"0\"]//*[@data-kendo-grid-column-index=\"0\"]")
    private WebElement selectItem;
    @FindBy(xpath = "//*[contains(text(), ' طباعة الباركود ')]")
    private WebElement printBarCodeCor;

    @FindBy(xpath = "//*[@class=\"mat-ripple mat-tab-label mat-focus-indicator ng-star-inserted\"]//*[contains(text(), 'المرفقات')]")
    private WebElement attachmentBtn;
    @FindBy(xpath = "//*[@aria-label=\"أخترالملفات\"]")
    private WebElement selectFile;
    @FindBy(xpath = "//*[contains(text(), ' رفع الملفات ')]")
    private WebElement uploadFile;
    @FindBy(xpath = "//*[@name=\"files\"]")
    private WebElement addFile;
    @FindBy(xpath = "//*[@class=\"k-grid-container ng-star-inserted\"]//*[@href=\"javascript:;\"]")
    private WebElement checkFileName;
    @FindBy(xpath = "//*[text()='المعاملات المسددة']")
    private WebElement connectedCorTab;
    @FindBy(xpath = "//*[@class=\"btn btn-secondary btn-sm font-weight-bold me-2\"]")
    private WebElement addCorToGridBtn;
    @FindBy(xpath = "//button[@class=\"btn btn-sm btn-light-success me-1\"]")
    private WebElement saveConnectedCorBtn;
    @FindBy(xpath = "//*[text()='نـعم']")
    private WebElement yesBtn;
    @FindBy(xpath = "//button[text()=' إستلام ']")
    private WebElement receiveBtn;

    @FindBy(xpath = "//*[contains(text(), 'رفض')]")
    private WebElement refuseBtn;

    @FindBy(id = "comment")
    private WebElement refuseCommentTxt;

    @FindBy(xpath = "//*[@class=\"mat-dialog-actions ng-star-inserted\" ]//*[contains(text(), 'رفض')]")
    private WebElement refuseSuccessBtn;


    @FindBy(xpath = "//*[contains(text(), ' تتبع الإحالات ')]")
    private WebElement followCases;


    @FindBy(xpath = "//*[@class=\"k-touch-action-auto ng-star-inserted\" and @data-kendo-grid-column-index=\"2\" and contains(text(), ' رفض')]")
    private WebElement followComment;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;


    }

    public String createInternalCorrespondence(String attachmentsCount, String strFooter, String strTitle, String strSignerName, String strForward, String corTypeStr) {

        wait.until(ExpectedConditions.visibilityOf(createMnu));
        createMnu.click();
        wait.until(ExpectedConditions.visibilityOf(createInternal));
        createInternal.click();
        corData(attachmentsCount, strFooter, strTitle, strSignerName, strForward, corTypeStr);
        return idTxt.getAttribute("value");
    }

    public void callmenu() {
        wait.until(ExpectedConditions.visibilityOf(corMnu));
        corMnu.click();
    }

    public String createInternalCorrespondenceLeft(String attachmentsCount, String strFooter, String strTitle, String strSignerName, String strForward, String corTypeStr) {
        String home = System.getProperty("user.home");

        wait.until(ExpectedConditions.elementToBeClickable(draftMnu));
        draftMnu.click();
        wait.until(ExpectedConditions.visibilityOf(createLeftMnu));
        createLeftMnu.click();
        wait.until(ExpectedConditions.visibilityOf(createLeftInternal));
        createLeftInternal.click();
        corData(attachmentsCount, strFooter, strTitle, strSignerName, strForward, corTypeStr);
        return idTxt.getAttribute("value");

    }

    private void corData(String attachmentsCount, String strFooter, String strTitle, String strSignerName, String strForward, String corTypeStr) {

        titleTxt.sendKeys(strTitle + LocalTime.now().format(DateTimeFormatter.ofPattern("ss")));
        attachmentsCountTxt.sendKeys(attachmentsCount);
        footerTxt.sendKeys(strFooter);
        signerNameTxt.sendKeys(strSignerName);
        executingAgencyDdl.click();
        wait.until(ExpectedConditions.elementToBeClickable(executingAgencyItemDdl));
        executingAgencyItemDdl.click();
        forwardTxt.sendKeys(strForward);
        actions.moveToElement(corTypeDdl).click().build().perform();
        actions.sendKeys(corTypeStr).build().perform();
        actions.sendKeys(Keys.TAB).build().perform();

        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(idTxt));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(idTxt, "value"));
        serverError.click();
    }

    private boolean transferDataOriginal(String strCorNo, boolean internal, boolean OneEmployees, String employeeStr) {

        addBtn.click();
        dprtmentDDl.click();
        dprtmentItemDdl.click();
        boolean result = false;

        if (OneEmployees) {
            actions.sendKeys(Keys.TAB).build().perform();
            actions.sendKeys(employeeStr).click().build().perform();
            System.out.println("one employee");
        }


        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(Keys.SPACE).build().perform();
        actions.sendKeys(Keys.TAB).build().perform();
        System.out.println("original");

        deliveryTypeDdl.click();
        deliveryTypeItemDdl.click();

        SubmitTransferBtn.click();

        if (internal) {
            draftMnu.click();
        }
        //assertion
        result = searchCor(strCorNo);
        return result;
    }

    private boolean transferDataNotOriginal(boolean OneEmployees, String employeeStr) {

        addBtn.click();
        dprtmentDDl.click();
        dprtmentItemDdl.click();
        boolean result = false;

        if (OneEmployees) {
            actions.sendKeys(Keys.TAB).build().perform();
            actions.sendKeys(employeeStr).build().perform();
            actions.moveToElement(employeeDDl).click().build().perform();
            // actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            System.out.println("one employee");
        }

        actions.sendKeys(Keys.TAB).build().perform(); //go to employee
        actions.sendKeys(Keys.TAB).build().perform();//go to original
        actions.sendKeys(Keys.TAB).build().perform();//go to delivery way
        deliveryTypeDdl.click();
        deliveryTypeItemDdl.click();

        SubmitTransferBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(draftMnu));
        draftMnu.click();
        itemChck.click();
        traceBtn.click();
        for (WebElement item : transferlst) {
            if (item.getText().contains("تحويل")) {
                result = true;
                System.out.println("transfer is found");
            } else {
                result = false;
                System.out.println("transfer is not found");
            }

        }
        closeTransferBtn.click();
        return result;
    }

    public boolean transfer(@NotNull String menuMode, boolean original, boolean OneEmployees, String employeeStr) {
        switch (menuMode) {
            case "draft":
                wait.until(ExpectedConditions.elementToBeClickable(draftMnu));
                draftMnu.click();
                break;
            case "generalInbox":
                wait.until(ExpectedConditions.elementToBeClickable(inboxMnu));
                inboxMnu.click();
                break;
            case "MyInbox":
                wait.until(ExpectedConditions.elementToBeClickable(myInboxMnu));
                myInboxMnu.click();
                break;
            default:
                System.out.println("No menu selected");
        }

        wait.until(ExpectedConditions.elementToBeClickable(itemChck));
        itemChck.click();
        transferBtn.click();
        if (original) {
            String strCorNo = checkedCorNo.getText();
            return transferDataOriginal(strCorNo, false, OneEmployees, employeeStr);
        } else return transferDataNotOriginal(OneEmployees, employeeStr);
    }
//
//    public boolean transferOutSide(boolean original, boolean OneEmployees, String employeeStr) {
//
//        wait.until(ExpectedConditions.elementToBeClickable(draftMnu));
//        draftMnu.click();
//        wait.until(ExpectedConditions.elementToBeClickable(itemChck));
//        itemChck.click();
//        transferBtn.click();
//        if (original) {
//            String strCorNo = checkedCorNo.getText().toString();
//            return transferDataOriginal(strCorNo, false, OneEmployees, employeeStr);
//        } else
//            return transferDataNotOriginal(OneEmployees, employeeStr);
//
//    }

    public boolean transferInternal(String strCorNo, boolean original, boolean OneEmployees, String employeeStr) {

        wait.until(ExpectedConditions.elementToBeClickable(InternalTransfer));
        InternalTransfer.click();
        if (original) return transferDataOriginal(strCorNo, true, OneEmployees, employeeStr);
        else return transferDataNotOriginal(OneEmployees, employeeStr);
    }

    public String UploadHardAttachment(String attachmentType) {

        PrintStream out = null;
        out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

        hardAttachmentTab.click();

        wait.until(ExpectedConditions.elementToBeClickable(addLineHardAttachBtn));
        addLineHardAttachBtn.click();
        wait.until(ExpectedConditions.visibilityOf(attachementDll));
        actions.moveToElement(attachementDll).click().build().perform();

        out.println("grid text   :" + typeColumn.getText());

        actions.sendKeys(attachmentType).build().perform();
        actions.sendKeys(Keys.TAB).build().perform();
        addLineHardAttachBtn.click();

        actions.sendKeys("كرتونة").build().perform();

        out.println("grid text1   :" + typeColumn.getText());
        submitBtn.click();

        return typeColumn.getText();
    }

    public boolean printBarCor(String barcodeFileName) {

        wait.until(ExpectedConditions.elementToBeClickable(draftMnu));
        draftMnu.click();

        itemChck.click();
        wait.until(ExpectedConditions.visibilityOf(printBarCodeCor));
        printBarCodeCor.click();
        boolean fileResult = false;
        String home = System.getProperty("user.home");
        String fileName = barcodeFileName + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        File uploadedFile = new File(new File(home, "Downloads"), fileName + ".pdf");
        //assertion
        Path path = Paths.get(uploadedFile.toString());
        System.out.println("file path is : " + path);
        if (Files.exists(path)) {
            // file exist
            System.out.println("file is exist");
            fileResult = true;
        } else {
            fileResult = false;
            System.out.println("file is not  exist");
        }
        return fileResult;
    }

    public boolean uploadAttachment(String uploadFileStr) {
        attachmentBtn.click();

        addFile.sendKeys(uploadFileStr);
        wait.until(ExpectedConditions.visibilityOf(uploadFile));
        uploadFile.click();
        submitBtn.click();
        //assertion
        boolean index = true;
        String fileNameActual = checkFileName.getText();
        System.out.println("text1 :" + fileNameActual);
        if (fileNameActual.length() > 0) {
            index = true;
            System.out.println("file is exist");
        } else {
            index = false;
            System.out.println("file is not  exist");
        }
        return index;
    }

    public boolean connectedCorAddition() {
        connectedCorTab.click();

        wait.until(ExpectedConditions.elementToBeClickable(addCorToGridBtn));
        addCorToGridBtn.click();
        wait.until(ExpectedConditions.visibilityOf(itemChck));
        itemChck.click();
        String selectedCor = typeColumn.getText();
        System.out.println("selected : " + selectedCor);
        saveConnectedCorBtn.click();
        yesBtn.click();
        submitBtn.click();
        //assertion
        String addedCor = typeColumn.getText();
        System.out.println("added : " + addedCor);
        if (addedCor.equals(selectedCor)) {
            System.out.println("success");
            return true;
        } else {
            System.out.println("failed");
            return false;
        }
    }

    public boolean receiveCorrespondence(String corNo) {
        boolean result = false;
        inboxMnu.click();
        itemChck.click();
        receiveBtn.click();
        //assertion
        //not found at inbox
        boolean found = searchCor(corNo);
        if (found) {
            System.out.println("Opps, found in  inbox");
        } else {
            System.out.println("Not found successfully in  inbox");
        }

        //found in myinbox
        myInboxMnu.click();
        found = searchCor(corNo);
        if (found) {
            System.out.println("found successfully in cor");
            result = true;
        } else {
            System.out.println("opps, not found in my cor");
            result = false;
        }
        return result;
    }

    private boolean searchCor(String strCorNo) {
        boolean result = false;
        // wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.click();
        searchTxt.sendKeys(strCorNo);
        searchBtn.click();
        // the inserted cor no
        System.out.println("strCorNo: " + strCorNo);

        //the cor number at the grid
        System.out.println("corNo: " + corNo.getText());

        if (corNo.getText().equals(strCorNo)) {
            result = true;
            System.out.println("found");
        } else {
            result = false;
            System.out.println("not found");
        }
        return result;
    }

    public void refuseCor(String commentRefuseStr) {


        itemChck.click();
        refuseBtn.click();
        wait.until(ExpectedConditions.visibilityOf(refuseCommentTxt));

        refuseCommentTxt.sendKeys(commentRefuseStr);
        refuseSuccessBtn.click();

    }


    public boolean findRefuseCor(@NotNull String menuMode, String cmmStr) {
        boolean found = false;
        boolean result = false;
        switch (menuMode) {
            case "draft":
                wait.until(ExpectedConditions.elementToBeClickable(draftMnu));
                draftMnu.click();


                break;
            case "generalInbox":
                wait.until(ExpectedConditions.elementToBeClickable(inboxMnu));
                inboxMnu.click();
                String corNo = idTxt.getText();
                refuseCor(cmmStr);
                myInboxMnu.click();
                found = searchCor(corNo);
                if (found) {
                    System.out.println("found successfully in cor");
                    result = true;
                } else {
                    System.out.println("opps, not found in my cor");
                    result = false;
                }
                break;
            case "MyInbox":
                wait.until(ExpectedConditions.elementToBeClickable(myInboxMnu));
                myInboxMnu.click();
                refuseCor(cmmStr);
                myInboxMnu.click();
                itemChck.click();
                traceBtn.click();
                for (WebElement item : transferlst) {
                    if (item.getText().contains("رفض")) {
                        result = true;
                        System.out.println("transfer is found");
                    } else {
                        result = false;
                        System.out.println("transfer is not found");
                    }

                }
                closeTransferBtn.click();
                break;
            default:
                System.out.println("No menu selected");
        }
        return result;
    }
}

