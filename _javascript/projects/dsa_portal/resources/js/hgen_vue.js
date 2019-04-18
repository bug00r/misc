
dsa.tools.hgen.vue = {
  el: '#dsa_portal_hgen',
  data: {
    heros: dsa.services.heroService._heros.getElementsByTagName('heros')[0],
    labels: dsa.resources.text.labels,
    currenthero: null,
    currentheroid: -1,
    state: {
      changed: {
        heroname: false
      }
    },
    somethingChanged: false,
    newhero: null
  },
  beforeMount: function() {

  },
  mounted: function() {
     
  },
  methods: {
    stateChanged: function(statename) {
      const state = this.state.changed[statename];
      return (!state || state);
    },
    toggleStateChanged: function(statename) {
      this.state.changed[statename] = !this.state.changed[statename];
    },
    setName: function(event) {
      if ( this.currenthero !== null) {
        let name = $(event.target).val();
        this.currenthero.setAttribute('name', name);
        this.toggleStateChanged('heroname');
        this.newhero.getAttributeNode('name').value = name;
      }
    },
    getName: function() {
      return (this.currenthero ? this.currenthero.getAttribute('name') : "");
    },
    selectHero : function(event) {
      let id = $(event.target).val();
      if (id > 0) {
        this.currenthero = this.heros.querySelector(`hero[id='${id}']`);
        this.newhero = this.heros.querySelector(`hero[id='${id}']`).__proto__;
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
    getHeroNameByIndex: function(index) {
      let name = this.heros.children[index].getAttribute('name');
      return name ? name : this.labels['dsa.portal.tool.hgen.noname'];
    }
  }
}