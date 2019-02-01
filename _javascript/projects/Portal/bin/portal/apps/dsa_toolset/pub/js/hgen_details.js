
dsa_toolset_hgen_details = new Vue({
    el: "#dsa-toolset-hgen-details-app",
    data: {
        hero: []
    },
    beforeMount: function() {
        this.hero[0] =  dsa_toolset_hgen.$data.selectedHero[0];
    }
})