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


def randomEmail = "test${System.currentTimeMillis()}@qwerty.com"

def randomPassword = "Pass@${System.currentTimeMillis()}"

def firstNames = ['Fazza', 'Lin', 'Kai', 'Zhen', 'Alya']

def lastNames = ['Chen', 'Wijaya', 'Putra', 'Li', 'Santoso']

def randomFullName = "${firstNames[new Random().nextInt(firstNames.size())]} ${lastNames[new Random().nextInt(lastNames.size())]}"

WebUI.openBrowser('')

WebUI.navigateToUrl(url)

WebUI.callTestCase(findTestCase('Register Verification/Register - New User Test'), [('fullName') : randomFullName, ('email') : randomEmail, ('password') : randomPassword])

WebUI.callTestCase(findTestCase('Login Verification/Login validation'), [('email') : randomEmail, ('password') : randomPassword])

WebUI.callTestCase(findTestCase('Cart Verification/Add Product to Test Case'), null)

WebUI.click(findTestObject('Checkout and payment/btn_checkout'))

WebUI.click(findTestObject('Checkout and payment/page_profile_settings'))

WebUI.newTab('https://qwerty.abiyyu.xyz/webhook-simulator')

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Checkout and payment/va_number_field_webhook'), vaCode)

WebUI.click(findTestObject('Checkout and payment/btn_check_bill'))

WebUI.click(findTestObject('Checkout and payment/btn_webhook_pay_bill'))

WebUI.click(findTestObject('Checkout and payment/msg_payment_successfully'))

WebUI.switchToWindowIndex(0)

WebUI.refresh()

WebUI.click(findTestObject('Checkout and payment/status_order_paid'))

WebUI.closeBrowser()