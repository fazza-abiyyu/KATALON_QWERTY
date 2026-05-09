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

WebUI.click(findTestObject('Login/icon_sign_in'))

WebUI.click(findTestObject('Reset password/span_forget_password'))

WebUI.setText(findTestObject('Reset password/email_field'), email)

WebUI.click(findTestObject('Reset password/btn_send_otp'))

WebUI.click(findTestObject('Reset password/msg_successfully_send_otp'))

WebUI.delay(10)

def random6Digit = 100000 + new Random().nextInt(900000)

WebUI.setText(findTestObject('Reset password/otp_code_field'), random6Digit.toString())

WebUI.setText(findTestObject('Reset password/new_password_field'), password)

WebUI.setText(findTestObject('Reset password/confirm_password_field'), password)

WebUI.click(findTestObject('Reset password/btn_reset_password'))

WebUI.click(findTestObject('Reset password/msg_invalid_otp'))

WebUI.closeBrowser()

