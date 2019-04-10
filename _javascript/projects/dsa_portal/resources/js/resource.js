let dsa = {};
dsa.resources = dsa.resources || {};

dsa.resources.text = dsa.resources.text || "text_resource";
dsa.resources.html = dsa.resources.html || {
    "calc" : "calc.html",
    "lexicon" : "lexicon.html",
    "hgen" : "hgen.html",
    "eq" : "eq.html",
    "talent" : "talent.html",
    "breed" : "breed.html",
    "default": "default.html"
};

for(const htmlentry in dsa.resources.html) {
   dsa.resources.html[htmlentry] = Base64.decode(dsa.resources.html[htmlentry]);
}

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

for(const xmlentry in dsa.resources.xml) {
    dsa.resources.xml[xmlentry] = new DOMParser().parseFromString(Base64.decode(dsa.resources.xml[xmlentry]), "application/xml");
 }
