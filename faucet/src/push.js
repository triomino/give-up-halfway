let shell = require('shelljs')

const buildTemplate = project => `docker build -t ${project} ${project}`
const buildScripts = {
  'rolling-machine': buildTemplate('rolling-machine'),
  'pokeball': buildTemplate('pokeball'),
  // TODO: restart server it self automatically.
  'faucet': 'yarn',
}

// test commits contains deploy string
const deployString = 'lets go!'
const shouldDeploy = commits => commits.filter(
  commit => commit['message'].indexOf(deployString) >= 0
).length > 0


function runScriptWithPushEvent(e) {
  const {payload: {ref, commits}} = e


  if (ref === 'refs/heads/master' || shouldDeploy(commits)) {
    console.log('rebuilding')
    shell.exec(`git fetch origin ${ref} && git reset --hard origin/${ref}`)
    // currently any push will cause all images to rebuild
    for (let project in buildScripts) {
      shell.exec(buildScripts[project])
    }
    console.log('building complete')
  }
}

module.exports = {
  runScriptWithPushEvent
}
