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

def randomInvalidEmail = "test${System.currentTimeMillis()}.com"

def firstNames = ['Fazza', 'Lin', 'Kai', 'Zhen', 'Alya']

def lastNames = ['Chen', 'Wijaya', 'Putra', 'Li', 'Santoso']

def randomFullName = "$firstNames[new Random().nextInt(firstNames.size())] $lastNames[new Random().nextInt(lastNames.size())]"

WebUI.openBrowser('')

WebUI.navigateToUrl(url)

WebUI.click(findTestObject('Register/icon_sign_up'))

WebUI.setText(findTestObject('Register/full_name_field'), randomFullName)

WebUI.setText(findTestObject('Register/email_field'), randomInvalidEmail)

WebUI.setEncryptedText(findTestObject('Register/password_field'), 'f7IgQFd4qQo=')

WebUI.click(findTestObject('Register/btn_create_account'))

WebUI.click(findTestObject('Register/msg_please_enter_a_valid_email_address'))

WebUI.click(findTestObject('Register/msg_validation_email_field'))

WebUI.closeBrowser()

