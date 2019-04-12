
dsa.tools.hgen.vue = {
  el: '#dsa_portal_hgen',
  data: {
    heros: dsa.services.heroService._heros.getElementsByTagName('heros')[0],
    labels: dsa.resources.text.labels,
    currenthero: null,
    currentheroid: -1,
  },
  beforeMount: function() {

  },
  mounted: function() {
     
  },
  methods: {
    selectHero : function(event) {
      let id = $(event.target).val();
      if (id > 0) {
        this.currenthero = this.heros.querySelector(`hero[id='${id}']`);
      }
    },
    addNewHero : function() {
      let new_hero = dsa.services.heroService.addHero();
      this.currenthero = new_hero;
      this.currentheroid = new_hero.getAttribute('id');
    },
    removeHero : function() {
      const deleted_hero = this.heros.removeChild(this.currenthero);
      this.currenthero = null;
      this.currentheroid = -1;
    },
    refreshHerolistEntry: function() {
      this.currentheroid = -1;
      this.currentheroid = this.currenthero.getAttribute('id');
    }, 
    getHeroNameByIndex: function(index) {
      let name = this.heros.children[index].getAttribute('name');
      return name ? name : this.labels['dsa.portal.tool.hgen.noname'];
    }
  }
}