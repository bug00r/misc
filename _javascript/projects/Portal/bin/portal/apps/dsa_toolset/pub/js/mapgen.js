
dsa_toolset_mapgen = new Vue({
    el: "#dsa-toolset-mapgen-app",
    data: {
        name: "DSA Toolset - Map Generator"
    },
    mounted: function() {
        portal.$data.appname = this.name;
    }
})
