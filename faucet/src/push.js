let shell = require('shelljs')


mapBranchToProject = {
  'api': 'rolling-machine',
  'nginx': 'pokeball',
  'deploy': 'faucet'
}

buildScripts = {
  'rolling-machine': 'docker build -t rolling-machine rolling-machine',
  'pokeball': 'docker build -t pokeball pokeball',
  // TODO: restart server it self automaticly.
  'faucet': 'yarn',
}

updateService = [

]

function runScriptWithPushEvent(e) {
  // const list = e.payload.ref.split('/')
  // const branch = list.length > 0 ? list[list.length-1] : undefined
  // if (branch) {
  //   const project = mapBranchToProject[branch];
  //   shell.exec(`docker build -t ${branch} `)
  // }

  // currently any push will cause all image to rebuild
  for (let project in buildScripts) {
    shell.exec(buildScripts[project])
  }


}

module.export = {
  runScriptWithPushEvent
}
