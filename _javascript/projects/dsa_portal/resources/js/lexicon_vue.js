dsa.tools.lexicon.vue = {
  el: '#dsa_portal_lexicon',
  data: {
    labels: dsa.resources.text.labels,
    selected: {
      category: 'all',
      group: 'all'
    },
    categories: [],
    groups: [],
    filter: "",
    result: []
  },
  mounted: function() {
    this.calcCategories();
    this.calcGroups();
    this.calcResult();
  },
  methods:{
    getSelectedCategories: function() {
      let categories = [];
      if (this.selected.category === 'all') {
        for ( let category in dsa.resources.xml ) {
          categories.push(category);
        }
      } else {
        categories.push(this.selected.category);
      }

      return categories;
    },
    getSelectedGroups: function() {
      let categories = this.getSelectedCategories();

      let groups = []
      for (let category of categories) {
        if ( this.selected.group === 'all' ) {
          for(let group of dsa.resources.xml[category].querySelectorAll("group")) {
            groups.push({name: group.getAttribute("name")});
          }
        } else {
          groups.push({name: this.selected.group});
        }
      }

      return groups;
    },
    calcGroups: function() {

      this.groups = [];

      this.selected.group = 'all';

      this.groups = this.getSelectedGroups();
    },
    calcCategories: function() {
      for ( let category in dsa.resources.xml ) {
        this.categories.push(category);
      }
      this.selected.category = 'equipments';
    },
    calcResult: function() {
      this.result = [];

      let categories = this.getSelectedCategories();

      let groups = this.getSelectedGroups();

      for (let category of categories) {
        for (let group of groups) {          
          let pattern = `group[name='${group.name}'] > *[name*='${this.filter}' i]`;
          if (!!!this.filter) {
            pattern = `group[name='${group.name}'] > *:not([name*='${this.filter}' i])`;
          }
          for(let item of dsa.resources.xml[category].querySelectorAll(pattern)) {
            this.result.push({name: item.getAttribute("name"), node: item});
          }
       }
      }
      console.log(this.result);
    }
  }
}
