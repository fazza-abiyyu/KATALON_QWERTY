import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(url)

WebUI.callTestCase(findTestCase('Login Verification/Login validation'), [('email') : email, ('password') : password])

WebUI.callTestCase(findTestCase('Cart Verification/Add Product to Test Case'), null)

WebUI.click(findTestObject('Checkout and payment/btn_checkout'))

WebUI.click(findTestObject('Checkout and payment/btn_place_order'))

WebUI.click(findTestObject('Checkout and payment/btn_bca_virtual_account'))

WebUI.click(findTestObject('Checkout and payment/btn_get_payment_va_code'))

//WebUI.waitForElementVisible(findTestObject('null'), 20)
//
//WebUI.scrollToElement(findTestObject('null'), 5)
String vaCode = WebUI.getText(findTestObject('Checkout and payment/text_va_code'))

WebUI.newTab(url + '/webhook-simulator')

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Checkout and payment/va_number_field_webhook'), vaCode)

WebUI.click(findTestObject('Checkout and payment/btn_check_bill'))

WebUI.click(findTestObject('Checkout and payment/btn_webhook_pay_bill'))

WebUI.click(findTestObject('Checkout and payment/msg_payment_successfully'))

WebUI.switchToWindowIndex(0)

WebUI.click(findTestObject('Checkout and payment/status_order_paid'))

WebUI.closeBrowser()

