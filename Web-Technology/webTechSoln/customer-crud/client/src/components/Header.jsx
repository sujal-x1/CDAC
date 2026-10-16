const navigation = [
  { id: "home", label: "Home" },
  { id: "contact", label: "Contact Us" }
];

function Header({ page, user, onNavigate, onLogout }) {
  return (
    <header className="site-header">
      <a
        className="brand"
        href="#home"
        onClick={(event) => {
          event.preventDefault();
          onNavigate("home");
        }}
      >
        <span className="brand-mark" aria-hidden="true">C</span>
        <span>
          <strong>Customer Desk</strong>
          <small>CDAC practical</small>
        </span>
      </a>

      <nav className="main-nav" aria-label="Main navigation">
        {navigation.map((item) => (
          <button
            className={`nav-link${page === item.id ? " is-active" : ""}`}
            key={item.id}
            type="button"
            aria-current={page === item.id ? "page" : undefined}
            onClick={() => onNavigate(item.id)}
          >
            {item.label}
          </button>
        ))}
        {user === "VITA" && (
          <button
            className={`nav-link${page === "customers" ? " is-active" : ""}`}
            type="button"
            aria-current={page === "customers" ? "page" : undefined}
            onClick={() => onNavigate("customers")}
          >
            List Customer
          </button>
        )}
      </nav>

      <div className="header-account">
        {user ? (
          <>
            <span className="user-badge" title={`Signed in as ${user}`}>
              <span className="status-dot" aria-hidden="true" />
              {user}
            </span>
            <button className="button button-outline button-small" type="button" onClick={onLogout}>
              Log out
            </button>
          </>
        ) : (
          <button
            className="button button-dark button-small"
            type="button"
            onClick={() => onNavigate("login")}
          >
            Log in
            <span aria-hidden="true">↗</span>
          </button>
        )}
      </div>
    </header>
  );
}

export default Header;
