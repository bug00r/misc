dsa.tools.calc.vue = {
  el: '#dsa_portal_calc',
  data: {
    labels: dsa.resources.text.labels,
    tawcols : ["A*", "A", "B", "C", "D", "E", "F", "G", "H"],
    tawcolobj : {},
    taw: { min: -3, max: 31},
    selected: { col: 0, min: -3, max: -3, talent: -1},
    coloffset : 3,
    talents: [],
    notepad : [],
    possibilities: {allowedrest: false, min: 1, max: 2000, visible: false, ap: 0, result: [[],[],[],[],[],[],[],[],[]] },
    tawvalues: [
      [5,5,5,5,1,1,1,2,4,5,6,8,9,11,12,14,15,17,19,20,22,24,25,27,29,31,32,34,36,38,40,42,43,45,48],
      [5,5,5,5,1,2,3,4,6,7,8,10,11,13,14,16,17,19,21,22,24,26,27,29,31,33,34,36,38,40,42,44,45,47,50],
      [10,10,10,10,2,4,6,8,11,14,17,19,22,25,28,32,35,38,41,45,48,51,55,58,62,65,69,73,76,80,84,87,91,95,100],
      [15,15,15,15,2,6,9,13,17,21,25,29,34,38,43,47,51,55,60,65,70,75,80,85,95,100,105,110,115,120,125,130,135,140,150],
      [20,20,20,20,3,7,12,17,22,27,33,39,45,50,55,65,70,75,85,90,95,105,110,115,125,130,140,145,150,160,165,170,180,190,200],
      [25,25,25,25,4,9,15,21,28,34,41,48,55,65,70,80,85,95,105,110,120,130,135,145,155,165,170,180,190,200,210,220,230,240,250],
      [40,40,40,40,6,14,22,32,41,50,60,75,85,95,105,120,130,140,155,165,180,195,210,220,230,250,260,270,290,300,310,330,340,350,375],
      [50,50,50,50,8,18,30,42,55,70,85,95,10,125,140,160,175,190,210,220,240,260,270,290,310,330,340,360,380,400,420,440,460,480,500],
      [100,100,100,100,16,35,60,85,110,140,165,195,220,250,280,320,350,380,410,450,480,510,550,580,620,650,690,720,760,800,830,870,910,950,1000]
    ]
  },
  beforeMount: function() {
    this.talents = dsa.resources.xml.talents.querySelectorAll('talent')
    console.log("talents added");
    for ( const [i, value] of this.tawcols.entries() ) {
      this.tawcolobj[value] = i;
    }
  },
  mounted: function() {
    $("#toolnavbtn").click(function(event) {
      $("#toolnav").toggleClass("is-active");
    });     
  },
  methods: {
    calcTawRaw: function(item) {
      let _min = Math.max(Number(item.min), this.taw.min);
      let _max = Math.min(Number(item.max), this.taw.max);
      let range = _max - _min;
      let add = ( range < 0 ? -1 : 1 );
      let result = 0;
      let selectedcol = Number(item.col);

      for (let cur = (_min + 1); cur <= _max; cur += add) {
        
        result += this.tawvalues[selectedcol][cur + this.coloffset];

      }

      return result;
    },
    calcTaw: function() {
        
        let _min = Math.max(Number(this.selected.min), this.taw.min);
        let _max = Math.min(Number(this.selected.max), this.taw.max);

        let selectedcol = Number(this.selected.col);      

        return this.calcTawRaw({ min: _min, max: _max, col: selectedcol});
    },
    selectCategory: function() {
      this.selected.talent = -1;
    },
    selectTalent : function(event) {
      let index = $(event.target).val();
      let category = this.talents[index].getAttribute('inc');
      this.selected.col = this.tawcolobj[category];
    },
    notepadSummary: function() {
      let result = 0;

      for ( item of this.notepad ) {
        result += this.calcTawRaw(item);
      }

      return result;
    },
    calcItem: function(item) {
      return this.calcTawRaw(item);
    },
    removeNotepadItem: function(index) {
      this.notepad.splice( index, 1 );
    },
    addNotepadItem: function() {
      let min = Number(this.selected.min);
      let max = Number(this.selected.max);

      let col = Number(this.selected.col);
      let talent = Number(this.selected.talent);

      this.notepad.push({ min, max, col, talent });

    },
    closePossibilities: function() {
      this.possibilities.visible = false;
    },
    openPossibilities: function() {
      this.possibilities.visible = true;
    },
    calcPossibilities: function() {
      let min = Number(this.possibilities.min);
      let max = Number(this.possibilities.max);
      let ap = Number(this.possibilities.ap);
      let offset = -3;
      let level_counter_max = 34;

      this.possibilities.result = [[],[],[],[],[],[],[],[],[]];

      for ( const [i, category] of this.tawcols.entries() ) {
        
        let level_counter = 0;
        for (let basis = 0; basis <= level_counter_max; basis += 1) {
          let level_basis = basis;
          let result = 0;
          for (let cur = level_basis + 1; cur <= level_counter_max; cur += 1) {
            
            let add_value = this.tawvalues[i][cur];
            let temp = result + add_value;
            let step_done = false;
            if ( temp <= ap) {
              result += add_value;
              if ( result === ap ) {
                step_done = true;
              }
              if ( cur == level_counter_max ) {
                // ap limit not reached but max level reached
                basis = level_counter_max; //skipping category because you can have all of them above
                step_done = true;
              }
            } else {
              step_done = true;
              cur -= 1;
              // ap limit reached
            }
            
            if ( step_done ) {
              //save result
              if ( result > 0 ) {
                let rest = Math.max(result, ap) - Math.min(result, ap);
                if (this.possibilities.allowedrest || ( !this.possibilities.allowedrest && rest === 0 )) {
                  this.possibilities.result[i].push({from: level_basis + offset, to: cur + offset, ap: result, rest: rest});
                }          
              }
              break;
            }
          }
        }
      }
    }
  }
}