
dsa_toolset_dungeongen = new Vue({
    el: "#dsa-toolset-dungeongen-app",
    data: {
        name: "DSA Toolset - Dungeon Generator"
    },
    mounted: function() {
        portal.$data.appname = this.name;
    }
})
