import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testdata.TestDataFactory as TDF
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def data = TDF.findTestData('Data Files/users')
for (def row = 1; row <= data.getRowNumbers(); row++) {
  def name = data.getValue('name', row)
  def job = data.getValue('job', row)
  def resp = WS.sendRequest(findTestObject('Object Repository/API/POST_CreateUser', ['name':name,'job':job]))
  WS.verifyResponseStatusCode(resp, 201)
  def j = new JsonSlurper().parseText(resp.getResponseBodyContent())
  assert j.id != null
}
