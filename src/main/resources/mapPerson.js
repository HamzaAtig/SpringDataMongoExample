function () { 
  /* count person with name= Monica and live in England then count there old*/
    if (this.name == 'Monica') {
        for (var i = 0; i < this.addresses.length; i++) {
          if(this.addresses[i].state=='England'){
            emit('Monica', this.age);
            break;
          }
        }
	       
	   }
}
