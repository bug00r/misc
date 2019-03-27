
const dsa_portal = new Vue({
    el: '#dsa_portal',
    data: {
      labels: dsa.resources.text.labels,
      tools: dsa.tools,
      instances: {}
    },
    mounted: function() {

      $(".navbar-burger").click(function() {

        $(".navbar-burger").toggleClass("is-active");
        $(".navbar-menu").toggleClass("is-active");

      });
      
    },
    methods: {
      open: function(tool) {
        if ( !!!this.instances[tool] ) {
          let tool_config = this.tools[tool];
          this.instances[tool] = {};
          this.instances[tool].element = dsa.resources.html[tool_config.html];
          $("#content").html(this.instances[tool].element);
          this.instances[tool].vue = new Vue(tool_config.vue);
        } else {
          $("#content").html(this.instances[tool].vue.$el);
        }
      }
    }
})
