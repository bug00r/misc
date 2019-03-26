var dsa = dsa || {};
dsa.resources = dsa.resources || {};

dsa.resources.text = dsa.resources.text || "text_resource";
dsa.resources.html = dsa.resources.html || {
    "calc" : "calc.html",
    "lexicon" : "lexicon.html"
};

dsa.resources.html.calc = Base64.decode(dsa.resources.html.calc);
dsa.resources.html.lexicon = Base64.decode(dsa.resources.html.lexicon);

dsa.resources.xml = dsa.resources.xml || {
    "armor" : "armor.xml",
    "basehero" : "basehero.xml",
    "breeds" : "breeds.xml",
    "creatures" : "creatures.xml",
    "cultures" : "cultures.xml",
    "equipments" : "equipments.xml",
    "herbs" : "herbs.xml",
    "procontra" : "procontra.xml",
    "professions" : "professions.xml",
    "specialabilities" : "specialabilities.xml",
    "spells" : "spells.xml",
    "talents" : "talents.xml",
    "towns" : "towns.xml",
    "weapons" : "weapons.xml"
};

dsa.resources.xml.armor = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.armor), "application/xml");
dsa.resources.xml.basehero = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.basehero), "application/xml");
dsa.resources.xml.breeds = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.breeds), "application/xml");
dsa.resources.xml.creatures = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.creatures), "application/xml");
dsa.resources.xml.cultures = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.cultures), "application/xml");
dsa.resources.xml.equipments = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.equipments), "application/xml");
dsa.resources.xml.procontra = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.procontra), "application/xml");
dsa.resources.xml.professions = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.professions), "application/xml");
dsa.resources.xml.specialabilities = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.specialabilities), "application/xml");
dsa.resources.xml.spells = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.spells), "application/xml");
dsa.resources.xml.talents = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.talents), "application/xml");
dsa.resources.xml.herbs = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.herbs), "application/xml");
dsa.resources.xml.towns = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.towns), "application/xml");
dsa.resources.xml.weapons = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml.weapons), "application/xml");