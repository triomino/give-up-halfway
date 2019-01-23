let shell = require('shelljs')

const buildTemplate = project => `docker build -t ${project} ../${project}`
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
  const {payload: {ref, commit, after}} = e


  if (ref === 'refs/heads/master' || shouldDeploy(commits)) {
    console.log('building and deploying')
    shell.exec(`git fetch origin ${ref} && git reset --hard ${after}`)
    // currently any push will cause all images to rebuild
    // for (let project in buildScripts) {
    //  shell.exec(buildScripts[project])
    // }
    shell.exec('cd .. && docker-compose build && docker-compose push && docker stack deploy -c docker-compose.yml app')
    console.log('complete')
  }
}

module.exports = {
  runScriptWithPushEvent
}
