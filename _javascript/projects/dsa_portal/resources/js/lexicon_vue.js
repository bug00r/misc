dsa.tools.lexicon.vue = {
  el: '#dsa_portal_lexicon',
  components: {
    'eq': {
      /*data: function() {
        return {
          item: dsa_portal.$data.instances.lexicon.vue.$data.selectedresult
        }
      },*/
      props: ['item', 'labels'],
      template: dsa.resources.html.eq
    },
    'default': {
      /*data: function() {
        return {
          item: dsa_portal.$data.instances.lexicon.vue.$data.selectedresult
        }
      },*/
      props: ['item', 'labels'],
      template: dsa.resources.html.default
    }
  },
  data: {
    labels: dsa.resources.text.labels,
    selected: {
      category: 'all',
      group: 'all'
    },
    categories: [],
    groups: [],
    filter: "",
    result: [],
    modal: {
      template: 'default',
      visible: false,
      title: ""
    },
    selectedresult: null
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

      this.result = [];

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
    },
    selectResult: function(event) {
      let index = $(event.target).data("index");
      let item = this.result[index];
      let tag = item.node.tagName;
      
      this.modal.title = item.name;
      
      this.selectedresult = item;

      //this.modal.content = `<${tag}></${tag}>`;
      let template = 'default';

      if ( tag in dsa.resources.html ) {
        template = tag;
      }

      this.modal.template = template;

      this.modal.visible = true;
      //alert(`select: ${item.name} as Tag: ${tag}`);
    },
    closeModal: function() {
      this.modal.visible = false;
    }
  }
}
