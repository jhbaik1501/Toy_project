import React, {Component} from 'react';

class UpdateContent extends Component{
    constructor(props){
        super(props);
        this.state={
            id:this.props.data.id,
            title:this.props.data.title,
            desc:this.props.data.desc
        }
        this.inputFormHandler = this.inputFormHandler.bind(this)
    }

    inputFormHandler(e){
      this.setState({[e.target.name]: e.target.value});
    }
    render(){
        console.log(this.props.data);
        console.log('UpdateContent render');
        return (
            <article>
                <h2>Update</h2>
                {/* form은 다른 페이지로 넘어가는 기능이 무조건 실행된다. 여기서는 /create_process로 간다
                하지만 우리는 페이지 전환없이 react로 모든 기능을 구현하고 싶기 때문에 페이지가 바뀌지 않게
                e.preventDefault()를 사용해야 한다. */}
                <form action="/create_process" method="post"
                  onSubmit={function(e){
                    e.preventDefault();
                    this.props.onSubmit(
                      this.state.id,
                      this.state.title,
                      this.state.desc

                    )
                  }.bind(this)}
                >
                  <input type="hidden" name="id" value={this.state.id}></input>
                  <p><input 
                    type="text" 
                    name="title" 
                    placeholder="title"
                    value={this.state.title}
                    onChange={this.inputFormHandler}
                  >
                  </input>
                  </p>

                  <p>
                    <textarea 
                        name="desc" 
                        placeholder="description" 
                        value={this.state.desc}
                        onChange={this.inputFormHandler}
                        >
                    </textarea>
                  </p>
                  <p>
                    <input type="submit"></input>
                  </p>
                </form>
            </article>
      );
    }
  }

  export default UpdateContent;