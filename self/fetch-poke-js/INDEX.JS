// fetch("http://pokeapi.co/api/v2/pokemon/pikachu")
// .then(response =>{
//     if(!response.ok){
//         throw new Error("could not fetch resource")
//     }
//     return response.json()
// })
// .then(data => console.log(data.name))
// .catch(error=> console.error(error))
fetchData();

async function fetchData(){
    try{
        const pokemonName = document.getElementById("pokemonName").value.toLowerCase();
        const response = await fetch(`http://pokeapi.co/api/v2/pokemon/${pokemonName}`);
        
        if(!response.ok){
            throw new Error("couldnt find resource")
        }
        const data = await response.json();
        const pokemonSprite = data.sprites.front_default;
        const imgElement = document.getElementById("pokemonSprite");

        imgElement.src = pokemonSprite;
        imgElement.style = "block";

    }   
    catch(error){
        console.error(error)
    };
    
}