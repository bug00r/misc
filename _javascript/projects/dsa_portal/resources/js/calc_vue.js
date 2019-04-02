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
    possibilities: { min: 1, max: 2000, visible: false, ap: 0, result: {}},
    tawvalues: [
      5,    5,    10,   15,    20,    25,    40,    50,   100,
      5,    5,    10,   15,    20,    25,    40,    50,   100,
      5,    5,    10,   15,    20,    25,    40,    50,   100,
      5,    5,    10,   15,    20,    25,    40,    50,   100,
      1,    1,     2,    2,     3,     4,     6,     8,    16,
      1,    2,     4,    6,     7,     9,    14,    18,    35,
      1,    3,     6,    9,    12,    15,    22,    30,    60,
      2,    4,     8,   13,    17,    21,    32,    42,    85,
      4,    6,    11,   17,    22,    28,    41,    55,   110,
      5,    7,    14,   21,    27,    34,    50,    70,   140,
      6,    8,    17,   25,    33,    41,    60,    85,   165,
      8,   10,    19,   29,    39,    48,    75,    95,   195,
      9,   11,    22,   34,    45,    55,    85,   110,   220,
      11,   13,    25,   38,    50,    65,    95,   125,   250,
      12,   14,    28,   43,    55,    70,   105,   140,   280,
      14,   16,    32,   47,    65,    80,   120,   160,   320,
      15,   17,    35,   51,    70,    85,   130,   175,   350,
      17,   19,    38,   55,    75,    95,   140,   190,   380,
      19,   21,    41,   60,    85,   105,   155,   210,   410,
      20,   22,    45,   65,    90,   110,   165,   220,   450,
      22,   24,    48,   70,    95,   120,   180,   240,   480,
      24,   26,    51,   75,   105,   130,   195,   260,   510,
      25,   27,    55,   80,   110,   135,   210,   270,   550,
      27,   29,    58,   85,   115,   145,   220,   290,   580,
      29,   31,    62,   95,   125,   155,   230,   310,   620,
      31,   33,    65,  100,   130,   165,   250,   330,   650,
      32,   34,    69,  105,   140,   170,   260,   340,   690,
      34,   36,    73,  110,   145,   180,   270,   360,   720,
      36,   38,    76,  115,   150,   190,   290,   380,   760,
      38,   40,    80,  120,   160,   200,   300,   400,   800,
      40,   42,    84,  125,   165,   210,   310,   420,   830,
      42,   44,    87,  130,   170,   220,   330,   440,   870,
      43,   45,    91,  135,   180,   230,   340,   460,   910,
      45,   47,    95,  140,   190,   240,   350,   480,   950,
      48,   50,   100,  150,   200,   250,   375,   500,   1000
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
        
        result += this.tawvalues[((cur + this.coloffset) * 9) + selectedcol];

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

      for ( const [i, category] of this.tawcols.entries() ) {
        
        let level_counter = 0;
        for (let basis = (min + 1); basis <= level_counter_max; basis += 1) {
          let level_basis = basis;
          for (let cur = level_basis; cur <= level_counter_max; cur += 1) {
          
            result += this.tawvalues[((cur + this.coloffset) * 9) + selectedcol];;
    
          }
        }
      }
    }
  }
}