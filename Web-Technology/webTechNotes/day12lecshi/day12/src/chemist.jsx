import { people } from './data2.js';
import { getImageUrl } from './utils.js';

export default function App() {
  const chemists = people.filter(
    person => person.profession === 'chemist'
  );

  const listItems = chemists.map(person => (
    <li key={person.id}>
      <img
        src={getImageUrl(person)}
        alt={person.name}
        width="100"
        height="100"
      />
      <p>
        <b>{person.name}:</b>
        {' ' + person.profession + ' '}
        known for {person.accomplishment}
      </p>
    </li>
  ));

  return (
    <>
      <h1>Famous Chemists</h1>
      <ul>{listItems}</ul>
    </>
  );
}