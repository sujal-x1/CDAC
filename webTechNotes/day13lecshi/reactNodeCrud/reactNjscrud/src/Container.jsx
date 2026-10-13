import { useEffect, useState } from "react";
import { Search } from "./Search.jsx";

export function Container({ query }) {
  const [list, setList] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const controller = new AbortController();

    fetch("/ejson.json", { signal: controller.signal })
      .then((response) => {
        if (!response.ok) {
          throw new Error(`Request failed (${response.status}).`);
        }
        return response.json();
      })
      .then((data) => {
        if (!Array.isArray(data)) {
          throw new Error("The search data is not a list.");
        }
        setList(data);
      })
      .catch((requestError) => {
        if (requestError.name !== "AbortError") {
          setError(requestError.message);
        }
      })
      .finally(() => {
        if (!controller.signal.aborted) {
          setLoading(false);
        }
      });

    return () => controller.abort();
  }, []);

  const normalizedQuery = query.trim().toLowerCase();
  const filteredList = !normalizedQuery
    ? list
    : list.filter(
        (data) => data.gender?.toLowerCase() === normalizedQuery,
      );

  if (loading) return <p>Loading search data...</p>;
  if (error) return <p role="alert">Could not load search data: {error}</p>;

  return (
    <ul>
      {filteredList.map((listItem) => (
        <li key={listItem.code}>{listItem.code}</li>
      ))}
    </ul>
  );
}

function SearchData() {
  const [query, setQuery] = useState("");
  return (
    <section>
      <h1>Search sample data by gender</h1>
      <Search onQuery={setQuery} />
      <Container query={query} />
    </section>
  );
}

export default SearchData;