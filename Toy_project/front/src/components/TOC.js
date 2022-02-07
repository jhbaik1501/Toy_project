import React, {Component} from 'react';

class TOC extends Component{

  shouldComponentUpdate(newProps, newState){
    console.log('===>Toc render shouldComponentUpdate'
    , newProps
    , this.props.data
    );
    if(this.props.data === newProps.data){
      return false;
    }
    return true;
  }

  render(){
    var lists = [];
    var data = this.props.data;
    var i=0;
    while(i<data.length){
      lists.push(
        <li key = {data[i].id}>
          <a 
          href={"/content/"+data[i].id}
          data-id={data[i].id}
          onClick={function(e){
            e.preventDefault();
            this.props.onChangePage(e.target.dataset.id);
          }.bind(this)}
          //아래도 가능 bind의 두 번째 매개변수가 function의 
          //첫 번째 매개변수로 들어간다. 세 번째는 두 번째로 ....
          // onClick={function(id, e){
          //   e.preventDefault();
          //   this.props.onChangePage(e.target.dataset.id);
          // }.bind(this, data[i].id)}          
          >{data[i].title}</a>
        </li>);
      i+=1
    }
    return (
      <nav> 
          <ul>
              {lists}
          </ul>
      </nav>
    );
  }
  }

  export default TOC;