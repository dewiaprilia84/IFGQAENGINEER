import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def resp = WS.sendRequest(findTestObject('Object Repository/API/GET_UserList'))
WS.verifyResponseStatusCode(resp, 200)
def j = new JsonSlurper().parseText(resp.getResponseBodyContent())
assert j.data.size() > 0
