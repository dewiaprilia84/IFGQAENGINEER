\
import com.kms.katalon.core.util.KeywordUtil as K

def broker = 'host.docker.internal:9092'
def topic  = 'qa-events'

String cmd = "kcat -C -b ${broker} -t ${topic} -e -q -o -1 -c 1"
K.logInfo("Running: " + cmd)

def isWindows = System.getProperty('os.name').toLowerCase().contains('win')
def process = isWindows ?
  new ProcessBuilder('cmd','/c',cmd).redirectErrorStream(true).start() :
  new ProcessBuilder('bash','-lc',cmd).redirectErrorStream(true).start()

def out  = new String(process.getInputStream().readAllBytes(), 'UTF-8').trim()
int exit = process.waitFor()

K.logInfo("kcat exit=" + exit)
K.logInfo("kcat output=" + out)

if (exit != 0) {
  K.markWarning("kcat failed or Kafka not reachable.")
}
if (!out) {
  K.markWarning("No message consumed from topic '" + topic + "'.")
} else {
  K.logInfo("Message OK: " + out)
}
