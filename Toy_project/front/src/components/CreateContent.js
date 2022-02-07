import React, {Component} from 'react';

class CreateContent extends Component{
    render(){
        return (
            <article>
                <h2>Create</h2>
                {/* form은 다른 페이지로 넘어가는 기능이 무조건 실행된다. 여기서는 /create_process로 간다
                하지만 우리는 페이지 전환없이 react로 모든 기능을 구현하고 싶기 때문에 페이지가 바뀌지 않게
                e.preventDefault()를 사용해야 한다. */}
                <form action="/create_process" 
                  method="post"
                  onSubmit={function(e){
                    e.preventDefault();
                    this.props.onSubmit(
                        e.target.title.value,
                        e.target.desc.value
                    )
                    alert('Submit!!!!!');
                  }.bind(this)}
                >
                  <p><input type="text" name="title" placeholder="title"></input></p>
                  <p>
                    <textarea name="desc" placeholder="description"></textarea>
                  </p>
                  <p>
                    <input type="submit"></input>
                  </p>
                </form>
            </article>
      );
    }
  }

  export default CreateContent;