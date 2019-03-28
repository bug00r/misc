dsa.tools.lexicon.vue = {
  el: '#dsa_portal_lexicon',
  components: {
    'eq': {
      props: ['item', 'labels'],
      template: dsa.resources.html.eq
    },
    'talent': {
      props: ['item', 'labels'],
      template: dsa.resources.html.talent
    },
    'breed': {
      methods: {
        get: function(element, child_tag_name) {
          return element.getElementsByTagName(child_tag_name);
        },
        attr: function(elment, attributename) {
          return elment.getAttribute(attributename);
        }
      },
      props: ['item', 'labels'],
      template: dsa.resources.html.breed
    },
    'default': {
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
        let pattern = null;
        if ( this.selected.group === 'all' ) {
          pattern = "group"
        } else {
          pattern = `group[name='${this.selected.group}']`;
        }
        for(let group of dsa.resources.xml[category].querySelectorAll(pattern)) {
          groups.push({name: group.getAttribute("name"), category: category});
        }
      }

      return groups;
    },
    calcGroups: function() {

      this.result = [];

      this.groups = [];

      this.selected.group = 'all';

      this.groups = this.getSelectedGroups();

      this.calcResult();
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

      for (let group of groups) {          
        let pattern = `group[name='${group.name}'] > *[name*='${this.filter}' i]`;
        if (!!!this.filter) {
          pattern = `group[name='${group.name}'] > *:not([name*='*' i])`;
        }
        for(let item of dsa.resources.xml[group.category].querySelectorAll(pattern)) {
          this.result.push({name: item.getAttribute("name"), node: item, category: group.category});
        }
      }

    },
    selectResult: function(event) {
      let index = $(event.target).data("index");
      let item = this.result[index];
      let tag = item.node.tagName;
      
      this.modal.title = item.name;
      
      this.selectedresult = item;

      let template = 'default';

      if ( tag in dsa.resources.html ) {
        template = tag;
      }

      this.modal.template = template;

      this.modal.visible = true;

    },
    closeModal: function() {
      this.modal.visible = false;
    }
  }
}
