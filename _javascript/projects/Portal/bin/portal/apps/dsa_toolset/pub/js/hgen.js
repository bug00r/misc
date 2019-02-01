
dsa_toolset_hgen = new Vue({
    el: "#dsa-toolset-hgen-app",
    data: {
        newHeroName: "",
        newHeroNameMsg: "",
        selectedHero: [],
        savedheros: [],
        name: "DSA Toolset - Hero Generator"
    },
    mounted: function() {
        $.getJSON("/portal/dsa_toolset/hgen/savedheros",function(savedheros) {
            for (hero in savedheros.heroes) {
                dsa_toolset_hgen.$data.savedheros.push(savedheros.heroes[hero]);
            }
        });
        portal.$data.appname = this.name;
    },
    methods: {
        selectSavedHero: function(hero, event) {
            var that = this;
            //console.log(hero.hero[0]._attr.description);
            dsa_toolset_hgen.$data.selectedHero[0] = hero;  
            $.ajax({
                method: "GET",
                url: "/portal/dsa_toolset/html/hgen_details.html"
              })
                .done(function( herodetails ) {
                    $(that.$refs['herodetailsid']).html(herodetails);
            });
        },
        addNewHero: function(name) {

        },
        removeSelectedHero: function() {

        }, 
        clearNewHeroModal: function() {
            this.newHeroName = '';
            this.newHeroNameMsg = '';
        },
        handleAddNewHero: function(evt) {
            // Prevent modal from closing
            evt.preventDefault();
            if (!this.newHeroName) {
                this.newHeroNameMsg = 'Please enter Heros name';
            } else {
              this.handleNewHeroSubmit();
            }
        },
        handleNewHeroSubmit: function() {
            //here we add ajax post for new hero after success we will display message over ref
            //this.names.push(this.name)
            this.clearNewHeroModal();
            this.$refs.modal_new_hero.hide();
        }
    }
})