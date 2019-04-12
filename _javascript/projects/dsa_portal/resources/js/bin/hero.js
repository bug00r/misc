dsa.services = dsa.services|| {}

dsa.services.heroService = new(class HeroService {

    constructor () {
        //TODO add localstorage for heros
        this._heros = new DOMParser().parseFromString("<heros></heros>", "application/xml");
    }
    addHero () {
        const hero_el = dsa.resources.xml.basehero.getElementsByTagName("hero")[0].cloneNode(true);
        hero_el.setAttribute("name", "");
        hero_el.setAttribute('id', Date.now());
        this._heros.adoptNode(hero_el);
        this._heros.getElementsByTagName("heros")[0].appendChild(hero_el);
        return hero_el;
    }
})();


