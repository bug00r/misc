
dsa.services = {}

services.heroService = new(class HeroService {
    constructor () {
        //TODO add localstorage for heros
        this._heros = new DOMParser().parseFromString("<heros></heros>", "application/xml");
    }
    addHero (name) {
        console.log(`add hero ${name}`);
    }
})();

dsa.services = services;